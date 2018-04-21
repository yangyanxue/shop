package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserServiceImp;

/**
 * Servlet implementation class UserControl
 */

public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		response.setHeader("content-type", "text/html;charset=UTF-8");  
		response.setCharacterEncoding("UTF-8");  
		request.setCharacterEncoding("UTF-8");  	
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		String telnum = request.getParameter("telnum");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setTelnum(telnum);
		UserServiceImp ui = new UserServiceImp();
		boolean flag = ui.region(user);
		if(flag){
		   // request.getRequestDispatcher("../index.jsp").forward(request, response);
			 Cookie cookie = new Cookie("username", URLEncoder.encode(username,"UTF-8"));
			 cookie.setMaxAge(24*60*60);
			 cookie.setDomain("localhost");
			 cookie.setPath("/");
			 response.addCookie(cookie);
			response.sendRedirect("../index.jsp");
			}else{
				request.getRequestDispatcher("../index.jsp").forward(request, response);
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 
	

}
