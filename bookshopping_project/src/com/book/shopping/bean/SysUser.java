package com.book.shopping.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 系统用户bean
 * @author YYJC
 * @Date 2019年8月26日 下午7:45:03
 * @Version 1.0
 * @Company YYJC EDU
 */
public class SysUser implements Serializable {

	private static final long serialVersionUID = 8889761110472699155L;

	private int userNo;
	private String userLoginPccount;
	private String userLoginPass;
	private String userName;
	private String userTelephone;
	private String userEmail;
	private Timestamp userCreateTime;
	private Date userLoginTime;
	private Date userUploginTime;
	private int userLoginCount;
	private int userStatus;
	private String userHeaderImg;

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserLoginPccount() {
		return userLoginPccount;
	}

	public void setUserLoginPccount(String userLoginPccount) {
		this.userLoginPccount = userLoginPccount;
	}

	public String getUserLoginPass() {
		return userLoginPass;
	}

	public void setUserLoginPass(String userLoginPass) {
		this.userLoginPass = userLoginPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Timestamp getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(Timestamp userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public Date getUserLoginTime() {
		return userLoginTime;
	}

	public void setUserLoginTime(Date userLoginTime) {
		this.userLoginTime = userLoginTime;
	}

	public Date getUserUploginTime() {
		return userUploginTime;
	}

	public void setUserUploginTime(Date userUploginTime) {
		this.userUploginTime = userUploginTime;
	}

	public int getUserLoginCount() {
		return userLoginCount;
	}

	public void setUserLoginCount(int userLoginCount) {
		this.userLoginCount = userLoginCount;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserHeaderImg() {
		return userHeaderImg;
	}

	public void setUserHeaderImg(String userHeaderImg) {
		this.userHeaderImg = userHeaderImg;
	}

	public SysUser(int userNo, String userLoginPccount, String userLoginPass, String userName, String userTelephone,
			String userEmail, Timestamp userCreateTime, Date userLoginTime, Date userUploginTime, int userLoginCount,
			int userStatus, String userHeaderImg) {
		super();
		this.userNo = userNo;
		this.userLoginPccount = userLoginPccount;
		this.userLoginPass = userLoginPass;
		this.userName = userName;
		this.userTelephone = userTelephone;
		this.userEmail = userEmail;
		this.userCreateTime = userCreateTime;
		this.userLoginTime = userLoginTime;
		this.userUploginTime = userUploginTime;
		this.userLoginCount = userLoginCount;
		this.userStatus = userStatus;
		this.userHeaderImg = userHeaderImg;
	}

	public SysUser() {
		super();
	}

	public SysUser(String userLoginPccount, String userLoginPass) {
		super();
		this.userLoginPccount = userLoginPccount;
		this.userLoginPass = userLoginPass;
	}

	@Override
	public String toString() {
		return "SysUser [userNo=" + userNo + ", userLoginPccount=" + userLoginPccount + ", userLoginPass="
				+ userLoginPass + ", userName=" + userName + ", userTelephone=" + userTelephone + ", userEmail="
				+ userEmail + ", userCreateTime=" + userCreateTime + ", userLoginTime=" + userLoginTime
				+ ", userUploginTime=" + userUploginTime + ", userLoginCount=" + userLoginCount + ", userStatus="
				+ userStatus + ", userHeaderImg=" + userHeaderImg + "]";
	}

}
