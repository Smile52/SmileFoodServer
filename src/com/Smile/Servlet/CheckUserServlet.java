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

public class CheckUserServlet extends HttpServlet {

	public CheckUserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
        username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
        String password = request.getParameter("password");
		//String userPwd ="1234";
		 
		if (checkUserNum(username, password)) {
			out.print("Success");
			 
		} else {
			out.print("Failed");
		}
		// 返回信息到客户端
		
		
		//out.print("密码：" + password);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	public Boolean checkUserNum(String userNum, String userPwd) {
		Connection conn = ConnCreate.getConnection(
				"jdbc:mysql://localhost:3306/smilefood", "root", "1234");// 获取数据库连接
		UserInfoDao dao = new UserInfoDaoImpl(conn);
		UserInfo user = dao.QueryUser(userNum);
		//System.out.println("查询出来的"+user.getUserPwd());
		if (user.getUserPwd().equals(userPwd)) {
			//System.out.println("ssss");
			return true;
		}else

			return false;

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
