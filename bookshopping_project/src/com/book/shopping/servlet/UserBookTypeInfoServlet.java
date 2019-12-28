package com.book.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.shopping.bean.BookInfo;
import com.book.shopping.bean.BookTypeInfo;
import com.book.shopping.service.UserAuthorityManagerMenetServiceImpl;
import com.book.shopping.service.UserAuthorityManagerMenetServiceInter;
import com.book.shopping.util.Tools;

import net.sf.json.JSONArray;

public class UserBookTypeInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 570242543531343453L;

	private UserAuthorityManagerMenetServiceInter userAuthorityManagerMenetService= new UserAuthorityManagerMenetServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" invoke doGet methed ");
		String bookNo = req.getParameter("bookNo");
		String bookName = req.getParameter("bookName");
		String bookPublisher = req.getParameter("bookPublisher");
		double bookPrice = Double.parseDouble(req.getParameter("bookPrice"));
		String bookImage = req.getParameter("bookImage");
		String bookPubDateStr = req.getParameter("bookPubDateStr");
		Timestamp bookPubDate=Timestamp.valueOf(bookPubDateStr);
		String bookAuthor = req.getParameter("bookAuthor");
		String bookContent = req.getParameter("bookContent");
		String bookDesciption = req.getParameter("bookDesciption");
		String bookTypeNo = req.getParameter("bookTypeNo");
		BookInfo bookInfo = new BookInfo(bookNo, bookName, bookPublisher, bookPrice, bookImage, bookPubDate, bookAuthor, bookContent, bookDesciption, bookTypeNo);
		System.out.println(bookInfo);
		int rows = userAuthorityManagerMenetService.addBookInfo(bookInfo);
		String message="";
		if(rows==1){
			message="{\"message\":\"successed\"}";
		}else{
			message="{\"message\":\"failier\"}";
		}
		resp.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write(message);
		out.close();
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doBookTypeInfo...");
		String flag = req.getParameter("flag");
		if("BookTypeNo".equals(flag)){
			this.searBookTypeInfo(req, resp);
		}else if("BookNo".equals(flag)){
			this.autoKey(req, resp);
		}
	}	
	
	
	protected void searBookTypeInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BookTypeInfo> bookTypeInfos = userAuthorityManagerMenetService.searchBookListTypeInfo();
		String jsonArray = JSONArray.fromObject(bookTypeInfos).toString();
		System.out.println(bookTypeInfos.size());
		resp.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write(jsonArray);
		out.close();
		
	}
	
	protected void autoKey(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key=Tools.genrotorPrimaryKey("B", "bookinfo", "bookNo", "0001");
		resp.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String keyCopy="{\"key\":\""+key+"\"}";
		out.write(keyCopy);
		out.close();
	}
}
