package com.book.shopping.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	public EncodingFilter(){
		
	}
	@Override
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		response.setContentType("text/html;charset=UTF-8");
		ProccessEncodingWrap encodingWrapRequest = new ProccessEncodingWrap(request);
		chain.doFilter(encodingWrapRequest, response);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
/**
 * 针对请求要进行包装(装饰)
 * @author YYJC
 * @Date 2019年8月9日 下午4:18:43
 * @Version 1.0
 * @Company YYJC EDU
 */
class ProccessEncodingWrap extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	public ProccessEncodingWrap(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		return values[0];
	}
	
	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		if(null != values){
			return values;
		}
		return super.getParameterValues(name);//null
	}
	private boolean isEncoding = true;
	@Override
	public Map<String, String[]> getParameterMap() {
		String method = request.getMethod();
		if("post".equalsIgnoreCase(method)){
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return request.getParameterMap();
		}else if("get".equalsIgnoreCase(method)){
			Map<String, String[]> parameterMap = request.getParameterMap();
			Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
			if(isEncoding){
				for(Entry<String, String[]> entry : entrySet){
					String[] value = entry.getValue();
					if(null != value){
						for(int i = 0 ; i < value.length; i++){
							try {
								value[i] = new String(value[i].getBytes("iso-8859-1"),"UTF-8");
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}
					}
				}
				isEncoding = false;
			}
			return parameterMap;
		}
		return super.getParameterMap();
	}
}





