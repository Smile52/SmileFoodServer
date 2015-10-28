package com.Smile.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Connection连接类，创建和销毁
 * @author Smile
 *
 */
public final class ConnCreate {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * 连接类
	 * @param url 数据库的url
	 * @param user  数据库的用户名
	 * @param pwd   数据库的密码
	 * @return
	 */
	public static Connection getConnection(String url,String user,String pwd){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url,user,pwd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	/**
	 * 释放资源
	 * @param conn
	 * @param stmt
	 * @param rs
	 * @throws SQLException
	 */
	public static void close(Connection conn,PreparedStatement stmt,ResultSet rs)throws SQLException{
		if(conn!=null){
			conn.close();
		}
		if(stmt!=null){
			stmt.close();
		}
		if(rs!=null){
			rs.close();
		}
	}
}
