package com.Smile.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smile.Bean.Food;
import com.Smile.Config.Config;
import com.Smile.Jdbc.ConnCreate;
import com.Smile.Jdbc.FoodDao;
import com.Smile.Jdbc.FoodDaoImpl;
import com.google.gson.Gson;

public class FoodQueryServlet extends HttpServlet {
    private	List<Food> foodlist = new ArrayList<Food>();
    //final String IP="http://192.168.191.1:8080";
    private	Connection conn = ConnCreate.getConnection(
			"jdbc:mysql://localhost:3306/smilefood", "root", "8080");
	//生成Json
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		FoodDao dao = new FoodDaoImpl(conn);		
		foodlist = dao.queryFood(Config.IP);
		
		Gson gson=new Gson();
	
		String jsons= gson.toJson(foodlist);
		//这里输出的是一个jsonArray数据
		out.println(jsons);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");// 设置编码
		PrintWriter out = response.getWriter();
		
		
		FoodDao dao = new FoodDaoImpl(conn);
		request.setAttribute("FoodName", "FoodName");
		//request.setAttribute("description", "");
		foodlist = dao.queryFood(Config.IP);	
		request.getSession().setAttribute("objlist", foodlist);
		//request.setAttribute("objlist", foodlist);
		//response.sendRedirect("/SmileFoodServer/Food/Food.jsp");
		request.getRequestDispatcher("/Food/Food.jsp").forward(request,
			response);
		out.flush();
		out.close();
	}

}
