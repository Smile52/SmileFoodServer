package com.Smile.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Connection�����࣬����������
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
	 * ������
	 * @param url ���ݿ��url
	 * @param user  ���ݿ���û���
	 * @param pwd   ���ݿ������
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
	 * �ͷ���Դ
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
