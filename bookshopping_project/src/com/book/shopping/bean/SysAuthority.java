package com.book.shopping.bean;

import java.io.Serializable;

/**
 * 系统资源权限BEAN
 * @author YYJC
 * @Date 2019年8月26日 下午7:51:58
 * @Version 1.0
 * @Company YYJC EDU
 */
public class SysAuthority implements Serializable {

	private static final long serialVersionUID = -5558363472122267061L;

	private int authNo;
	private String authName;
	private int authParentNo;
	private String authImg;
	private String authUrl;
	private String authDesc;
	private int authOrderNumber;

	public int getAuthNo() {
		return authNo;
	}

	public void setAuthNo(int authNo) {
		this.authNo = authNo;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public int getAuthParentNo() {
		return authParentNo;
	}

	public void setAuthParentNo(int authParentNo) {
		this.authParentNo = authParentNo;
	}

	public String getAuthImg() {
		return authImg;
	}

	public void setAuthImg(String authImg) {
		this.authImg = authImg;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	public String getAuthDesc() {
		return authDesc;
	}

	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}

	public int getAuthOrderNumber() {
		return authOrderNumber;
	}

	public void setAuthOrderNumber(int authOrderNumber) {
		this.authOrderNumber = authOrderNumber;
	}

	public SysAuthority(int authNo, String authName, int authParentNo, String authImg, String authUrl, String authDesc,
			int authOrderNumber) {
		super();
		this.authNo = authNo;
		this.authName = authName;
		this.authParentNo = authParentNo;
		this.authImg = authImg;
		this.authUrl = authUrl;
		this.authDesc = authDesc;
		this.authOrderNumber = authOrderNumber;
	}

	public SysAuthority() {
		super();
	}

	@Override
	public String toString() {
		return "SysAuthority [authNo=" + authNo + ", authName=" + authName + ", authParentNo=" + authParentNo
				+ ", authImg=" + authImg + ", authUrl=" + authUrl + ", authDesc=" + authDesc + ", authOrderNumber="
				+ authOrderNumber + "]";
	}

}
