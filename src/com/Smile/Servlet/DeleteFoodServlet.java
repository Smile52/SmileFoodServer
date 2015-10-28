package com.Smile.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smile.Jdbc.ConnCreate;
import com.Smile.Jdbc.FoodDao;
import com.Smile.Jdbc.FoodDaoImpl;

public class DeleteFoodServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String foodId=request.getParameter("foodId");
		Connection conn = ConnCreate.getConnection(
				"jdbc:mysql://localhost:3306/smilefood", "root", "8080");
		FoodDao dao=new FoodDaoImpl(conn);
		int result=dao.deleteFood(Integer.parseInt(foodId));
		if(result==0){
			out.write("<script language='javascript'>alert('É¾³ýÊ§°Ü')</script>");
		}else{
			out.write("<script language='javascript'>alert('É¾³ý³É¹¦')</script>");
		}
		out.flush();
		out.close();
	}

}
