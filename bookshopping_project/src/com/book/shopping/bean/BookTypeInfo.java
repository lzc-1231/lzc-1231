package com.book.shopping.bean;

import java.io.Serializable;

/**
 * 图书类型Bean
 * @author YYJC
 * @Date 2019年7月11日 上午7:55:35
 * @Version 1.0
 * @Company YYJC EDU
 */
public class BookTypeInfo implements Serializable {

	private static final long serialVersionUID = 7517116832144386499L;
	/** 图书类型编号 */
	private String bookTypeNo;
	/** 图书类型名称 */
	private String bookTypeName;
	/** 图书类型链接URL */
	private String bookTypeLinkUrl;
	/** 图书类型图片URL */
	private String bookTypeImgUrl;
	/** 图书类型上级编号 */
	private String bookTypeParentNo;
	/** 图书类型排序号 */
	private int bookTypeOrderNo;
	/** 图书类型描述 */
	private String bookTypeDescipt;

	public String getBookTypeNo() {
		return bookTypeNo;
	}

	public void setBookTypeNo(String bookTypeNo) {
		this.bookTypeNo = bookTypeNo;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public String getBookTypeLinkUrl() {
		return bookTypeLinkUrl;
	}

	public void setBookTypeLinkUrl(String bookTypeLinkUrl) {
		this.bookTypeLinkUrl = bookTypeLinkUrl;
	}

	public String getBookTypeImgUrl() {
		return bookTypeImgUrl;
	}

	public void setBookTypeImgUrl(String bookTypeImgUrl) {
		this.bookTypeImgUrl = bookTypeImgUrl;
	}

	public String getBookTypeParentNo() {
		return bookTypeParentNo;
	}

	public void setBookTypeParentNo(String bookTypeParentNo) {
		this.bookTypeParentNo = bookTypeParentNo;
	}

	public int getBookTypeOrderNo() {
		return bookTypeOrderNo;
	}

	public void setBookTypeOrderNo(int bookTypeOrderNo) {
		this.bookTypeOrderNo = bookTypeOrderNo;
	}

	public String getBookTypeDescipt() {
		return bookTypeDescipt;
	}

	public void setBookTypeDescipt(String bookTypeDescipt) {
		this.bookTypeDescipt = bookTypeDescipt;
	}

	public BookTypeInfo(String bookTypeNo, String bookTypeName, String bookTypeLinkUrl, String bookTypeImgUrl,
			String bookTypeParentNo, int bookTypeOrderNo, String bookTypeDescipt) {
		super();
		this.bookTypeNo = bookTypeNo;
		this.bookTypeName = bookTypeName;
		this.bookTypeLinkUrl = bookTypeLinkUrl;
		this.bookTypeImgUrl = bookTypeImgUrl;
		this.bookTypeParentNo = bookTypeParentNo;
		this.bookTypeOrderNo = bookTypeOrderNo;
		this.bookTypeDescipt = bookTypeDescipt;
	}

	public BookTypeInfo() {
		super();
	}

	@Override
	public String toString() {
		return "BookTypeInfo [bookTypeNo=" + bookTypeNo + ", bookTypeName=" + bookTypeName + ", bookTypeLinkUrl="
				+ bookTypeLinkUrl + ", bookTypeImgUrl=" + bookTypeImgUrl + ", bookTypeParentNo=" + bookTypeParentNo
				+ ", bookTypeOrderNo=" + bookTypeOrderNo + ", bookTypeDescipt=" + bookTypeDescipt + "]";
	}

}
