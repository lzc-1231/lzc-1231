package com.book.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.shopping.bean.SysAuthority;
import com.book.shopping.bean.SysUser;
import com.book.shopping.bean.BookInfo;
import com.book.shopping.bean.BookTypeInfo;
import com.book.shopping.service.UserAuthorityManagerMenetServiceImpl;
import com.book.shopping.service.UserAuthorityManagerMenetServiceInter;
import com.book.shopping.util.MD5Utils;

import net.sf.json.JSONArray;

public class UserAuthorityManagerMenetServlet extends HttpServlet {

	private static final long serialVersionUID = 6062594967963986507L;
	
	private UserAuthorityManagerMenetServiceInter userAuthorityManagerMenetService= new UserAuthorityManagerMenetServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String flag = req.getParameter("flag");
		if("login".equals(flag)){
			System.out.println("abc");
			String loginUserAccount = req.getParameter("userLoginAccount");
			String loginUserPass = MD5Utils.md5(req.getParameter("loginUserPass"));
			SysUser sysUser = new SysUser();
			sysUser.setUserLoginPccount(loginUserAccount);
			sysUser.setUserLoginPass(loginUserPass);
			SysUser sysUserObj = userAuthorityManagerMenetService.userLoginOpeator(sysUser);
			Map<String, List<SysAuthority>> authorityMenuMap = userAuthorityManagerMenetService.searchUserAuthorityMenu(sysUserObj);
			if(null != sysUserObj){
				req.getSession().setAttribute("USER_OBJ", sysUserObj);
				//根据登录成功的用户查询出权限菜单呈现给首页的分类控制显示
				req.getSession().setAttribute("AUTHOTIRY_MENU_MAP", authorityMenuMap);
				resp.sendRedirect("../index.jsp");
			}else{
				resp.sendRedirect("../login.jsp");
			}
		}else{
			int page =  Integer.valueOf(req.getParameter("page"));
			int rows =  Integer.valueOf(req.getParameter("rows"));
			int infonumber=userAuthorityManagerMenetService.selectBookInfoSeize();
			List<BookInfo> bookInfo = userAuthorityManagerMenetService.searchBookListInfo(page,rows);
			JSONArray jsonArray = JSONArray.fromObject(bookInfo);
			String bookInfostr = jsonArray.toString();
			System.out.println(bookInfostr);
			String infostr ="{\"total\":"+infonumber+",\"rows\":"+bookInfostr+"}";
			resp.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(infostr);
			out.close();
		}
		
	}
}
