package com.book.shopping.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.book.shopping.bean.BookInfo;
import com.book.shopping.bean.BookTypeInfo;
import com.book.shopping.bean.SysAuthority;
import com.book.shopping.bean.SysUser;
import com.book.shopping.dao.UserAuthorityManagerMenetDaoImpl;
import com.book.shopping.dao.UserAuthorityManagerMenetDaoInter;


/**
 * 用户权限管理业务逻辑实现类
 * @author YYJC
 * @Date 2019年8月30日 下午2:44:12
 * @Version 1.0
 * @Company YYJC EDU
 */
public class UserAuthorityManagerMenetServiceImpl implements UserAuthorityManagerMenetServiceInter {
	
	private UserAuthorityManagerMenetDaoInter userAuthorityManagerMenetDao = new UserAuthorityManagerMenetDaoImpl();

	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.service.UserAuthorityManagerMenetServiceInter#userLoginOpeator(com.book.shopping.bean.SysUser)
	 */
	@Override
	public SysUser userLoginOpeator(SysUser sysUser) {
		String sql = "select * from sys_users where "
				+ " user_login_account = ?"
				+ "  and user_login_pass = ?";
		Object[] parameters = new Object[]{sysUser.getUserLoginCount(),sysUser.getUserLoginPass()};
		return userAuthorityManagerMenetDao.userLoginOperator(sql, parameters);
	}
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.service.UserAuthorityManagerMenetServiceInter#searchUserAuthorityMenu(com.book.shopping.bean.SysUser)
	 */
	@Override
	public Map<String, List<SysAuthority>> searchUserAuthorityMenu(SysUser sysUser) {
		
		Map<String, List<SysAuthority>> menuAuthorityMap = new HashMap<String, List<SysAuthority>>();
		//1、根据当前用户成功用户编号作为条件查询一级菜单
		String sql = "select * from sys_authority where auth_no in("
				+ " select sa.auth_no from sys_users su ,sys_user_role sur ,sys_role sr,sys_role_authority sra,sys_authority sa"
				+ " where su.user_no=sur.user_no"
				+ " and sur.role_no=sr.role_no"
				+ " and sr.role_no=sra.role_no"
				+ " and sra.auth_first_menu_no=sa.auth_no"
				+ " and su.user_no=?) ";
		Object[] parameterFirst = new Object[]{sysUser.getUserNo()};
		
		List<SysAuthority> sysAuthorities = userAuthorityManagerMenetDao.searchFirstMenuAuthority(sql, parameterFirst);
		
		//2、根据已经查询出的一级菜单集合循环查出每个一级菜单从属的二级菜单集合
		for(SysAuthority sysAuthority : sysAuthorities){
			String sqlOther = "select * from sys_authority where auth_no in("
					+ " select sa.auth_no from sys_users su ,sys_user_role sur ,sys_role sr,sys_role_authority sra,sys_authority sa"
					+ " where su.user_no=sur.user_no"
					+ " and sur.role_no=sr.role_no"
					+ " and sr.role_no=sra.role_no"
					+ " and sra.auth_second_menu_no=sa.auth_no"
					+ " and auth_first_menu_no=?) ";
			Object[] parameterSecond = new Object[]{sysAuthority.getAuthNo()};
			
			List<SysAuthority> secondAuthority = userAuthorityManagerMenetDao.searchFirstMenuAuthority(sqlOther, parameterSecond);
		
			menuAuthorityMap.put(sysAuthority.getAuthName(), secondAuthority);
		}
		//3、将(1)(2)拼凑成一个Map
		
		return menuAuthorityMap;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.service.UserAuthorityManagerMenetServiceInter#selectBookInfoSeize()
	 */
	@Override
	public int selectBookInfoSeize() {
		String sql="select count(*) infosize from bookinfo";
		return userAuthorityManagerMenetDao.selctBookInfoSize(sql);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.service.UserAuthorityManagerMenetServiceInter#searchBookListInfo(int, int)
	 */
	@Override
	public List<BookInfo> searchBookListInfo(int page, int size) {
		String sql="select bookNo,bookName,bookPublisher,bookPrice,bookImage, "
				+ " bookPubDate,bookAuthor,bookContent,bookDesciption "
				+ " ,bookTypeName from bookinfo b inner join booktypeinfo b1 on b.bookTypeNo=b1.bookTypeNo limit ?,?";
		Object[] object={((page-1)*size),size};
		return userAuthorityManagerMenetDao.searchBookListInfo(sql, object);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.service.UserAuthorityManagerMenetServiceInter#searchBookListTypeInfo()
	 */
	@Override
	public List<BookTypeInfo> searchBookListTypeInfo() {
		String sql = "select * from booktypeinfo";
		return userAuthorityManagerMenetDao.dropDown(sql);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.service.UserAuthorityManagerMenetServiceInter#addBookInfo(com.book.shopping.bean.BookInfo)
	 */
	@Override
	public int addBookInfo(BookInfo bookInfo) {
		String sql = "insert into bookinfo values(?,?,?,?,?,?,?,?,?,?)";
		Object[] object={bookInfo.getBookNo(),
				bookInfo.getBookName(),
				bookInfo.getBookPublisher(),
				bookInfo.getBookPrice(),
				bookInfo.getBookImage(),
				bookInfo.getBookPubDate(),
				bookInfo.getBookAuthor(),
				bookInfo.getBookContent(),
				bookInfo.getBookDesciption(),
				bookInfo.getBookTypeNo()};
		return userAuthorityManagerMenetDao.bookInfoCRUD(sql, object);
	}
	
	public static void main(String[] args) {
		/*SysUser sysUser = new SysUser();
		sysUser.setUserNo(10000);
		
		Map<String, List<SysAuthority>> map = new UserAuthorityManagerMenetServiceImpl().searchUserAuthorityMenu(sysUser);
		
		for(Entry<String, List<SysAuthority>> entries : map.entrySet()){
			System.out.println("一级菜单:" + entries.getKey());
			for(SysAuthority sysAuthorities : entries.getValue()){
				System.out.println("\t二级菜单:" + sysAuthorities.getAuthName());
			}
		}*/
		System.out.println(new UserAuthorityManagerMenetServiceImpl().searchBookListTypeInfo());
	}
}
