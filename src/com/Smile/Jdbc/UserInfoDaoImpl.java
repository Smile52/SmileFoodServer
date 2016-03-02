package com.Smile.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Smile.Bean.UserInfo;

public class UserInfoDaoImpl implements UserInfoDao {
	private Connection conn=null;
	public UserInfoDaoImpl(Connection conn){
		this.conn=conn;
	}
	
	@Override
	public int AddUser(UserInfo userInfo) {
		PreparedStatement stmt=null;
		int result=0;
		String sql="insert into user_tb(usernum,userpwd,userphone,username) values(?,?,?,?) ";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, userInfo.getUserNum().toString());
			stmt.setString(2, userInfo.getUserPwd().toString());
			stmt.setString(3, userInfo.getUserPhone().toString());
			stmt.setString(4, userInfo.getUserName().toString());
			result=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ConnCreate.close(null, stmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 查询
	 */
	@Override
	public UserInfo QueryUser(String userNum) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		UserInfo user=null;
		String sql="SELECT * FROM user_tb where usernum= ?";
		//System.out.println("ww"+sql);
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, userNum);
			System.out.println("ww"+sql);
			rs=stmt.executeQuery();
			
			if(rs.next()){
				user=new UserInfo();
				user.setUserId(rs.getInt(1));
				user.setUserNum(rs.getString(2));
				user.setUserPwd(rs.getString(3));
				user.setUserPhone(rs.getString(4));
				user.setUserName(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ConnCreate.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//释放资源
		}
		System.out.println("www"+user.getUserPwd());
		return user;
	}

}
