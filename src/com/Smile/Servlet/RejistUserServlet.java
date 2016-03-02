package com.Smile.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smile.Bean.UserInfo;
import com.Smile.Jdbc.ConnCreate;
import com.Smile.Jdbc.UserInfoDao;
import com.Smile.Jdbc.UserInfoDaoImpl;

public class RejistUserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RejistUserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
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

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = ConnCreate.getConnection(
				"jdbc:mysql://localhost:3306/smilefood", "root", "8080");// 获取数据库连接
		UserInfoDao dao = new UserInfoDaoImpl(conn);
		UserInfo user=new UserInfo();
		user.setUserName(request.getParameter("newname"));
		user.setUserNum(request.getParameter("newnum"));
		user.setUserPwd(request.getParameter("newpwd"));
		user.setUserPhone(request.getParameter("newphone"));
		System.out.println("6666"+request.getParameter("newnum"));
		System.out.println("777"+request.getParameter("newpwd"));
		int i=dao.AddUser(user);
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
}
