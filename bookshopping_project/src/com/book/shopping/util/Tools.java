package com.book.shopping.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.book.shopping.dao.BaseDao;

public class Tools {
	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public static String geratorUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 将日期类型转换成符合格式的字符串类型
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStringByDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月ddHH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 将符合日期格式的字符串转换成日期类型
	 * 
	 * @param string
	 * @return
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public static Date dateByString(String string) throws java.text.ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
		return sdf.parse(string);
	}

	/**
	 * 自动生成订单编号 DD_2019080715190001
	 * 
	 * @paramprefiex前缀(例如:DD_ 表示订单 US_ , SH_ ...)
	 * @paramtableName传入的表名
	 * @paramprimaryColumn当前表名的主键列名 @paramstartNumber起始编号(00001 , 10000) .
	 *                              max(key) 不存在 DD_2019080715190001 . max(key)
	 *                              存在 (1)DD_2019080715190008 (2)"0008"(String)
	 *                              -->int(8) (3) 8 + 1 = 9 (4)判断是否 9 10~99: 0补0
	 *                              1~9: 0000xx 100~999: 0xxx 1000~9999: xxxx
	 *                              select 主键名称 from 表名 where date = 当天
	 * @return
	 */
	public static String genrotorPrimaryKey(String prefiex, String tableName, String primaryColumn, String startNumber,
			Date date) {
		// 引入StringBuffer,并将前缀存入
		StringBuffer sb = new StringBuffer(prefiex);
		// 将Date日期类型格式化
		String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		// 添加至sb
		sb.append(dateStr);
		// 分别创建连接对象、预编译命令语句对象和结果集对象
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 保存查询到的主键值
		String key = "";
		// 保存截取的最后四位的字符串
		String subKey = "";
		// 保存截取的最后四位的数值
		int number = 0;
		try {
			// 建立连接
			conn = BaseDao.createConnection();
			// 编写sql语句
			String sql = "select max(" + primaryColumn + ") as pk from " + tableName;
			System.out.println(sql);
			// 执行sql语句，返回结果集
			stmt = conn.prepareStatement(sql);
			// 处理结果集
			rs = stmt.executeQuery();
			if (rs.next()) {
				// 通过别名获取值
				key = rs.getString("pk");
			}
			if ("".equals(key) || key == null) {// 如果为空，也就是主键列没有数据
				// 例如：DD_20190808162030+0001
				sb.append(startNumber);
			} else {// 不为空
				subKey = key.substring(17, 21);
				number = Integer.valueOf(subKey);
				number++;
				if (number >= 0 && number <= 9) {
					sb.append("000");
				} else if (number >= 10 && number <= 99) {
					sb.append("00");
				} else if (number >= 100 && number <= 999) {
					sb.append("0");
				}
				sb.append(number);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.freeSource(conn, stmt, rs);
		}
		return sb.toString();
	}

	public static String genrotorPrimaryKey(String prefiex, String tableName, String primaryColumn,
			String startNumber) {
		// 引入StringBuffer,并将前缀存入
		StringBuffer sb = new StringBuffer(prefiex);
		// 分别创建连接对象、预编译命令语句对象和结果集对象
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 保存查询到的主键值
		String key = "";
		// 保存截取的最后四位的字符串
		String subKey = "";
		// 保存截取的最后四位的数值
		int number = 0;
		try {
			// 建立连接
			conn = BaseDao.createConnection();
			// 编写sql语句
			String sql = "select max(" + primaryColumn + ") as pk from " + tableName;
			// 执行sql语句，返回结果集
			stmt = conn.prepareStatement(sql);
			// 处理结果集
			rs = stmt.executeQuery();
			if (rs.next()) {
				// 通过别名获取值
				key = rs.getString("pk");
			}
			if ("".equals(key) || key == null) {// 如果为空，也就是主键列没有数据
				// 例如：DD_20190808162030+0001
				sb.append(startNumber);
			} else {// 不为空
				subKey = key.substring(1, 5);
				number = Integer.valueOf(subKey);
				number++;
				if (number >= 0 && number <= 9) {
					sb.append("000");
				} else if (number >= 10 && number <= 99) {
					sb.append("00");
				} else if (number >= 100 && number <= 999) {
					sb.append("0");
				}
				sb.append(number);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.freeSource(conn, stmt, rs);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(genrotorPrimaryKey("B", "bookinfo", "bookNo", "0001"));
	}
}
