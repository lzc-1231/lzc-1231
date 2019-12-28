package com.book.shopping.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 系统角色BEAN
 * @author YYJC
 * @Date 2019年8月26日 下午7:48:24
 * @Version 1.0
 * @Company YYJC EDU
 */
public class SysRole implements Serializable {

	private static final long serialVersionUID = 1903689459110492901L;
	private int roleNo;
	private String roleName;
	private Timestamp roleCreatetime;
	private String roleDesc;

	public int getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(int roleNo) {
		this.roleNo = roleNo;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Timestamp getRoleCreatetime() {
		return roleCreatetime;
	}

	public void setRoleCreatetime(Timestamp roleCreatetime) {
		this.roleCreatetime = roleCreatetime;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public SysRole(int roleNo, String roleName, Timestamp roleCreatetime, String roleDesc) {
		super();
		this.roleNo = roleNo;
		this.roleName = roleName;
		this.roleCreatetime = roleCreatetime;
		this.roleDesc = roleDesc;
	}

	public SysRole() {
		super();
	}

	@Override
	public String toString() {
		return "SysRole [roleNo=" + roleNo + ", roleName=" + roleName + ", roleCreatetime=" + roleCreatetime
				+ ", roleDesc=" + roleDesc + "]";
	}

}
