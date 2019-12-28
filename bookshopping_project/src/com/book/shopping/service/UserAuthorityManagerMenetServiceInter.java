package com.book.shopping.service;

import java.util.List;
import java.util.Map;

import com.book.shopping.bean.BookInfo;
import com.book.shopping.bean.BookTypeInfo;
import com.book.shopping.bean.SysAuthority;
import com.book.shopping.bean.SysUser;

/**
 * 用户权限管理的业务逻辑接口类
 * @author YYJC
 * @Date 2019年8月30日 下午2:43:07
 * @Version 1.0
 * @Company YYJC EDU
 */
public interface UserAuthorityManagerMenetServiceInter {
	/**
	 * 1、用户登录操作
	 * @param sysUser
	 * @return
	 */
	SysUser userLoginOpeator(SysUser sysUser);
	/**
	 * 2、根据当前登录的用户对象查询出当前用户所有的权限菜单
	 * @param sysUser
	 * @return
	 */
	Map<String, List<SysAuthority>> searchUserAuthorityMenu(SysUser sysUser);
	
	/**
	 * 3、查询书籍数量
	 * @param sysUser
	 * @return
	 */
	int selectBookInfoSeize();
	
	/**
	 * 4、分页查询书籍信息
	 * @param sysUser
	 * @return
	 */
	List<BookInfo> searchBookListInfo(int page, int size);
	
	/**
	 * 5、下拉框查询
	 * @param bookTypeInfo
	 * @return
	 */
	List<BookTypeInfo> searchBookListTypeInfo();
	
	/**
	 * 6、新增图书信息
	 * @param bookInfo
	 * @return
	 */
	int addBookInfo(BookInfo bookInfo);
}
