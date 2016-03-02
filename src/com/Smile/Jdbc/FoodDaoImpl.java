package com.Smile.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Smile.Bean.Food;

public class FoodDaoImpl implements FoodDao {
	private Connection conn=null;
	public FoodDaoImpl(Connection conn){
		this.conn=conn;
	}
	/**
	 * ��Ӳ�
	 */
	@Override
	public int addFood(Food food) {
		PreparedStatement stmt=null;
		int result=0;
			String sql="insert into food_tb(foodname,foodprice,fooddetail,foodimagurl) values(?,?,?,?)";
			try {
				stmt=conn.prepareStatement(sql);
				stmt.setString(1, food.getFoodName());
				stmt.setFloat(2, food.getFoodPrice());
				stmt.setString(3, food.getFoodDetial());
				stmt.setString(4, food.getFoodUrl());
				result=stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					//�ͷ���Դ
					ConnCreate.close(null, stmt, null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		return result;
	}
	/**
	 * ��ѯ��
	 */
	@Override
	public List<Food> queryFood() {
		List<Food> foodlist=new ArrayList<Food>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select * from food_tb";
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				Food f=new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodPrice(rs.getFloat(3));
				f.setFoodDetial(rs.getString(4));
				f.setFoodUrl(rs.getString(5));
				f.setFoodCount(rs.getInt(6));
				foodlist.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//�ͷ���Դ
		}finally{
			try {
				ConnCreate.close(null, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return foodlist;
	}

	@Override
	public int deleteFood(int id) {
		PreparedStatement stmt=null;
		int result=0;
		String sql="delete from food_tb where foodid=?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
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

	@Override
	public int updateFood(int id, Food food) {
		
		
		return id;
		// TODO Auto-generated method stub

	}

}
