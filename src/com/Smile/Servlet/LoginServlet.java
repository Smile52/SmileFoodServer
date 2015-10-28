package com.Smile.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.jms.Message;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smile.Bean.Admin;
import com.Smile.Jdbc.AdminDao;
import com.Smile.Jdbc.AdminDaoImpl;
import com.Smile.Jdbc.ConnCreate;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = ConnCreate.getConnection(
				"jdbc:mysql://localhost:3306/smilefood", "root", "8080");// 获取数据库连接
		checkAdmin(request,response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void checkAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Admin userBean = new Admin();
		String AdminName = request.getParameter("username");

		String AdminPwd = request.getParameter("password");
		userBean.setAdminUserPwd(request.getParameter("password"));

		Connection conn = ConnCreate.getConnection(
				"jdbc:mysql://localhost:3306/smilefood", "root", "8080");// 获取数据库连接
		AdminDao dao = new AdminDaoImpl(conn);
		Admin admin = dao.queryAdmin(AdminName);
		String forwad = null;// 请求转发
		if (AdminName.equals(admin.getAdminUserName())
				&& AdminPwd.equals(admin.getAdminUserPwd())) {
			forwad = "/servlet/FoodQueryServlet" ;//登录成功后跳转到菜查询Servlet
			RequestDispatcher rd = request.getRequestDispatcher(forwad);
			
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/UserLogin/error.jsp");// 验证失败采用请求重定向跳转到错误页面

		}

		//System.out.println(userBean.toString());

	}

	
}
