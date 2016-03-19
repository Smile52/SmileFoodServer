package com.Smile.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Smile.Bean.Food;
import com.Smile.Jdbc.ConnCreate;
import com.Smile.Jdbc.FoodDao;
import com.Smile.Jdbc.FoodDaoImpl;

public class AddFoodServlet extends HttpServlet {
	private ServletContext sc;
	private String savaPath;
	private String imgurl;//ͼƬurl
	private Food newfood;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		newfood=uploadImg(request,response);
		Connection conn = ConnCreate.getConnection(
				"jdbc:mysql://localhost:3306/smilefood", "root", "8080");
		FoodDao dao=new FoodDaoImpl(conn);
		//System.out.println("555"+newfood.getFoodName());
	
		int result=dao.addFood(newfood);
		if(result==0){
			out.write("<script language='javascript'>alert('��Ӳ�ʧ��!')</script>");
		}else{
			out.write("<script language='javascript'>alert('��Ӳ˳ɹ�!')</script>");
		}
		
		out.flush();
		out.close();
	}
	/**
	 * �ϴ�ͼƬ
	 * @param request
	 * @param response
	 */
	private Food uploadImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String url="/SmileFoodServer/FoodImgs/{0}";
		String imgUrl = null;
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//ͨ����������һ�������ļ��ϴ���ServletFileUpload����
		ServletFileUpload servletFileUpload=new ServletFileUpload(factory);
		Food nfood=new Food();
		try {
			List items=servletFileUpload.parseRequest(request);
			Iterator iterator=items.iterator();
			while(iterator.hasNext()){
				FileItem item=(FileItem) iterator.next();
				//�������ͨ������
				if(item.isFormField()){
					//System.out.println("���Ĳ������ƣ�"+item.getFieldName()+",���Ĳ���ֵ��"+item.getString("UTF-8"));
					switch (item.getFieldName()) {
					case "foodname":
						nfood.setFoodName(item.getString("UTF-8"));
						break;
					case "foodprice":
						nfood.setFoodPrice(Float.parseFloat(item.getString("UTF-8")));
						break;
					case "fooddetail":
						nfood.setFoodDetial(item.getString("UTF-8"));
						break;
					case "foodtype":
						nfood.setFoodType(Integer.parseInt(item.getString("UTF-8")));
					default:
						break;
					}
					
				}else{
					if(item.getName()!=null&&!item.getName().equals("")){						                              
                        File tempFile=new File(item.getName());
                        File file=new File(sc.getRealPath("/")+savaPath,tempFile.getName());
                        item.write(file);
                        System.out.println(file.getPath());
                        System.out.println("�ļ��ϴ��ɹ�");
                        imgUrl=MessageFormat.format(url, item.getName());
                        nfood.setFoodUrl(imgUrl);
                        //System.out.println("ͼƬ��uri"+imgUri);
					}else{
						System.out.println("û��ѡ���ϴ��ļ�");
					}
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ļ��ϴ�ʧ��");
		}
		return nfood;
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		savaPath=config.getInitParameter("savaPath");
		sc=config.getServletContext();
		
	}
}
