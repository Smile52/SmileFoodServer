package com.Smile.Servlet;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.Smile.Bean.Food;
import com.Smile.Jdbc.ConnCreate;
import com.Smile.Jdbc.FoodDao;
import com.Smile.Jdbc.FoodDaoImpl;

public class Test {

	public static void main(String[] args) {
		List<Food> foodlist=new ArrayList<Food>();
		Connection conn=ConnCreate.getConnection("jdbc:mysql://localhost:3306/smilefood", "root", "8080");
		FoodDao dao=new FoodDaoImpl(conn);
		 //foodlist=dao.queryFood();
		 for(Food food:foodlist){
			 System.out.println(food.toString());
		 }

	}

}
