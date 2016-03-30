package com.Smile.Servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smile.Bean.FoodId;
import com.Smile.Jdbc.ConnCreate;
import com.Smile.Jdbc.FoodDao;
import com.Smile.Jdbc.FoodDaoImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

public class OrderFoodServlet extends HttpServlet {
	private	Connection conn = ConnCreate.getConnection(
				"jdbc:mysql://localhost:3306/smilefood", "root", "1234");
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    //设置可以在页面中响应的内容类型及中文
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	    String values=request.getParameter("values");
	 
	    Gson gson=new Gson();
	    java.util.List<FoodId> list=new ArrayList<FoodId>();
	    list=gson.fromJson(values,new TypeToken<ArrayList<FoodId>>(){}.getType());
	    
	    System.out.println("smile"+list.size());
	    FoodDao dao = new FoodDaoImpl(conn);	
	    int result=dao.updateFood(list);
	    if(result==1){
	    	out.println("OK");
	    }else{
	    	out.println("False");
	    }
	    //out.println("woshul");
		out.flush();
		out.close();
	}

}
