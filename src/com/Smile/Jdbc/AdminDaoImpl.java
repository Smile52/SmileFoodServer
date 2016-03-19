package com.Smile.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Smile.Bean.Admin;

public class AdminDaoImpl implements AdminDao {
	private Connection conn=null;
	public AdminDaoImpl(Connection conn){
		this.conn=conn;
	}
	@Override
	public int addAdmin(Admin adminBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Admin adminBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Admin queryAdmin(String adminName) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Admin admin=null;
		String sql="SELECT * FROM admin_tb where adminname= ?";		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, adminName);		
			rs=stmt.executeQuery();
			if(rs.next()){
				admin=new Admin();
				admin.setAdminUserName(rs.getString(1));
				admin.setAdminUserPwd(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ConnCreate.close(conn, stmt, rs);//ÊÍ·Å×ÊÔ´
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
		return admin;
	}

	@Override
	public int updateAdmin(Admin admin, String AdminName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
