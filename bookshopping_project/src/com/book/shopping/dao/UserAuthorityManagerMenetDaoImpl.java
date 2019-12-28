package com.book.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.book.shopping.bean.BookInfo;
import com.book.shopping.bean.BookTypeInfo;
import com.book.shopping.bean.SysAuthority;
import com.book.shopping.bean.SysUser;
import com.book.shopping.dao.BaseDao;



/**
 * 用户权限管理的数据访问实现类
 * @author YYJC
 * @Date 2019年8月30日 下午2:31:18
 * @Version 1.0
 * @Company YYJC EDU
 */
public class UserAuthorityManagerMenetDaoImpl implements UserAuthorityManagerMenetDaoInter {
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.dao.UserAuthorityManagerMenetDaoInter#userLoginOperator(java.lang.String, java.lang.Object[])
	 */
	@Override
	public SysUser userLoginOperator(String sql, Object[] parameters) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		SysUser sysUser = null;
		try {
			conn = BaseDao.createConnection();
			statement = conn.prepareStatement(sql);
			if(null != parameters && 0 < parameters.length){
				for(int i = 0 ; i < parameters.length;i++){
					statement.setObject((i+1), parameters[i]);
				}
			}
			rs = statement.executeQuery();
			if(rs.next()){
				int userNo = rs.getInt("user_no");
				String userLoginPccount = rs.getString("user_login_account");
				String userLoginPass = rs.getString("user_login_pass");
				String userName = rs.getString("user_name");
				String userTelephone = rs.getString("user_telephone");
				String userEmail = rs.getString("user_email");
				Timestamp userCreateTime = rs.getTimestamp("user_create_time");
				Date userLoginTime = rs.getDate("user_login_time");
				Date userUploginTime = rs.getDate("user_uplogin_time");
				int userLoginCount = rs.getInt("user_login_count");
				int userStatus = rs.getInt("user_status");
				String userHeaderImg = rs.getString("user_header_img");
				sysUser = new SysUser(userNo, userLoginPccount, userLoginPass, userName, userTelephone, userEmail, userCreateTime, userLoginTime, userUploginTime, userLoginCount, userStatus, userHeaderImg);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.freeSource(conn, statement, rs);
		}
		
		return sysUser;
	}
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.dao.UserAuthorityManagerMenetDaoInter#searchFirstMenuAuthority(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<SysAuthority> searchFirstMenuAuthority(String sql, Object[] parameters) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<SysAuthority> sysAuthorities = new ArrayList<SysAuthority>();
		try {
			conn = BaseDao.createConnection();
			statement = conn.prepareStatement(sql);
			if(null != parameters && 0 < parameters.length){
				for(int i = 0 ; i < parameters.length;i++){
					statement.setObject((i+1), parameters[i]);
				}
			}
			rs = statement.executeQuery();
			while(rs.next()){
				int authNo = rs.getInt("auth_no");
				String authName = rs.getString("auth_name");
				int authParentNo = rs.getInt("auth_parent_no");
				String authImg = rs.getString("auth_img");
				String authUrl = rs.getString("auth_url");
				String authDesc = rs.getString("auth_desc");
				int authOrderNumber = rs.getInt("auth_order_number");
				SysAuthority sysAuthority = new SysAuthority(authNo, authName, authParentNo, authImg, authUrl, authDesc, authOrderNumber);
				sysAuthorities.add(sysAuthority);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.freeSource(conn, statement, rs);
		}
		return sysAuthorities;
	}
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.dao.UserAuthorityManagerMenetDaoInter#searchSecondMenuAuthority(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<SysAuthority> searchSecondMenuAuthority(String sql, Object[] parameters) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<SysAuthority> sysAuthorities = new ArrayList<SysAuthority>();
		try {
			conn = BaseDao.createConnection();
			statement = conn.prepareStatement(sql);
			if(null != parameters && 0 < parameters.length){
				for(int i = 0 ; i < parameters.length;i++){
					statement.setObject((i+1), parameters[i]);
				}
			}
			rs = statement.executeQuery();
			while(rs.next()){
				int authNo = rs.getInt("auth_no");
				String authName = rs.getString("auth_name");
				int authParentNo = rs.getInt("auth_parent_no");
				String authImg = rs.getString("auth_img");
				String authUrl = rs.getString("auth_url");
				String authDesc = rs.getString("auth_desc");
				int authOrderNumber = rs.getInt("auth_order_number");
				SysAuthority sysAuthority = new SysAuthority(authNo, authName, authParentNo, authImg, authUrl, authDesc, authOrderNumber);
				sysAuthorities.add(sysAuthority);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.freeSource(conn, statement, rs);
		}
		return sysAuthorities;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.dao.UserAuthorityManagerMenetDaoInter#selctBookInfoSize(java.lang.String)
	 */
	@Override
	public int selctBookInfoSize(String sql) {
		Connection con=null;
		PreparedStatement pre = null;
		ResultSet rs =null;
		int fh=0;
		try {
			con = BaseDao.createConnection();
			pre = con.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()){
				 fh=(Integer.valueOf(rs.getObject("infosize").toString()));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			BaseDao.freeSource(con, pre, rs);
		}
		return fh;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.dao.UserAuthorityManagerMenetDaoInter#searchBookListInfo(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<BookInfo> searchBookListInfo(String sql, Object[] object) {
		Connection con=null;
		PreparedStatement pre = null;
		ResultSet rs =null;
		List<BookInfo> bookInfo = new ArrayList<>();
		try {
			con = BaseDao.createConnection();
			pre = con.prepareStatement(sql);
			for(int i =0; i<object.length;i++){
				if(null!=object[i]&& 0<object.length){
					pre.setObject((i+1), object[i]);
				}
			}
			rs=pre.executeQuery();
			while(rs.next()){
				String bookNo=rs.getString("bookNo");
				String bookName=rs.getString("bookName");
				String bookPublisher=rs.getString("bookPublisher");
				Double bookPrice=rs.getDouble("bookPrice");
				String bookImage=rs.getString("bookImage");
				Timestamp bookPubDate=rs.getTimestamp("bookPubDate");
				SimpleDateFormat bookDate=new SimpleDateFormat("yyyy年MM月dd日  hh:mm:ss");
				String bookPubDateStr=bookDate.format(bookPubDate);
				String bookAuthor=rs.getString("bookAuthor");
				String bookContent=rs.getString("bookContent");
				String bookDesciption=rs.getString("bookDesciption");
				String bookTypeNo=rs.getString("bookTypeName");
				BookInfo bookInfos = new BookInfo(bookNo, bookName, bookPublisher, bookPrice, bookImage, bookPubDateStr, bookAuthor, bookContent, bookDesciption, bookTypeNo);
				bookInfo.add(bookInfos);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			BaseDao.freeSource(con, pre, rs);
		}
		return bookInfo;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.dao.UserAuthorityManagerMenetDaoInter#dropDown(java.lang.String)
	 */
	@Override
	public List<BookTypeInfo> dropDown(String sql) {
		Connection con=null;
		PreparedStatement pre = null;
		ResultSet rs =null;
		List<BookTypeInfo> bookTypeInfos = new ArrayList<BookTypeInfo>();
			try {
				con = BaseDao.createConnection();
				pre = con.prepareStatement(sql);
				rs = pre.executeQuery();
				while(rs.next()){
					String bookTypeNo = rs.getString("bookTypeNo");
					String bookTypeName = rs.getString("bookTypeName");
					String bookTypeLinkUrl = rs.getString("bookTypeLinkUrl");
					String bookTypeImgUrl = rs.getString("bookTypeImgUrl");
					String bookTypeParentNo = rs.getString("bookTypeParentNo");
					int bookTypeOrderNo = rs.getInt("bookTypeOrderNo");
					String bookTypeDescipt = rs.getString("bookTypeDescipt");
					BookTypeInfo bookTypeInfo = new BookTypeInfo(bookTypeNo, bookTypeName, bookTypeLinkUrl, bookTypeImgUrl, bookTypeParentNo, bookTypeOrderNo, bookTypeDescipt);
					bookTypeInfos.add(bookTypeInfo);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally{
				BaseDao.freeSource(con, pre, rs);
			}
		return bookTypeInfos;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.dao.UserAuthorityManagerMenetDaoInter#maxTypeNo(java.lang.String, java.lang.String)
	 */
	@Override
	public BookInfo maxTypeNo(String sql, String tableName) {
		Connection con= null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		BookInfo book = null ;
		try {
			con = BaseDao.createConnection();
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()){
				String bookNo=rs.getString("bookNo");
				String bookName=rs.getString("bookName");
				String bookPublisher=rs.getString("bookPublisher");
				Double bookPrice=rs.getDouble("bookPrice");
				String bookImage=rs.getString("bookImage");
				Timestamp bookPubDate=rs.getTimestamp("bookPubDate");
				SimpleDateFormat bookDate=new SimpleDateFormat("yyyy年MM月dd日  hh:mm:ss");
				String bookPubDateStr=bookDate.format(bookPubDate);
				String bookAuthor=rs.getString("bookAuthor");
				String bookContent=rs.getString("bookContent");
				String bookDesciption=rs.getString("bookDesciption");
				String bookTypeNo=rs.getString("bookTypeName");
				book  = new BookInfo(bookNo, bookName, bookPublisher, bookPrice, bookImage, bookPubDateStr, bookAuthor, bookContent, bookDesciption, bookTypeNo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.freeSource(con, pre, rs);
		}
		
		return book;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.dao.UserAuthorityManagerMenetDaoInter#bookInfoCRUD(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int bookInfoCRUD(String sql, Object[] object) {
		Connection con = null; 
		PreparedStatement pre = null;
		int rows = 0;
		try {
			con = BaseDao.createConnection();
			pre = con.prepareStatement(sql);
			if(null != object && 0 < object.length){
				for(int i = 0 ; i < object.length ; i++){
					pre.setObject((i+1),object[i]);
				}
			}
			rows = pre.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.freeSource(con, pre);
		}
		return rows;
	}
}
