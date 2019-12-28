package com.book.shopping.dao;

import java.util.List;

import com.book.shopping.bean.BookInfo;
import com.book.shopping.bean.BookTypeInfo;
import com.book.shopping.bean.SysAuthority;
import com.book.shopping.bean.SysUser;

/**
 * 用户权限管理的数据访问接口类
 * @author YYJC
 * @Date 2019年8月30日 下午2:28:22
 * @Version 1.0
 * @Company YYJC EDU
 */
public interface UserAuthorityManagerMenetDaoInter {
	/**
	 * 1、用户登录功能
	 * @param sql
	 * @param parameters
	 * @return
	 */
	SysUser userLoginOperator(String sql , Object[] parameters);
	/**
	 * 2、根据当前登录的用户编号查询该用户拥有一级菜单权限
	 * @param sql
	 * @param parameter
	 * @return
	 */
	List<SysAuthority> searchFirstMenuAuthority(String sql , Object[] parameter);
	/**
	 * 3、根据已经查询出的一级菜单编号作为条件查询该一级下的二级菜单集合
	 * @param sql
	 * @param parameter
	 * @return
	 */
	List<SysAuthority> searchSecondMenuAuthority(String sql , Object[] parameter);
	
	/**
	 * 3、查询书籍数量
	 * @param sysUser
	 * @return
	 */
	int selctBookInfoSize(String sql);
	
	/**
	 * 4、分页查询书籍信息
	 * @param sysUser
	 * @return
	 */
	List<BookInfo> searchBookListInfo(String sql, Object[] object);
	
	/**
	 * 5、查询BookTypeInfo表为下拉框提供数据
	 * @param sql
	 * @return
	 */
	List<BookTypeInfo> dropDown(String sql);
	
	/**
	 * 6、查询图书编号最大值
	 * @param sql
	 * @param tableName
	 * @return
	 */
	BookInfo maxTypeNo(String sql,String tableName);
	
	/**
	 * 7、增删改查
	 * @param sql
	 * @param object
	 * @return
	 */
	int bookInfoCRUD(String sql,Object[] object);
}
