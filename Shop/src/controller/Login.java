package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import service.UserServiceImp;
import sun.rmi.log.LogOutputStream;

public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");  
		response.setCharacterEncoding("UTF-8");  
		request.setCharacterEncoding("UTF-8"); 
		String action = request.getParameter("action");
		if (action.equals("login")){
			this.login(request, response);
		}
		if(action.equals("logout")){
			this.logout(request, response);
		}
	
       
       
       
		
	}
	public void login(HttpServletRequest request, HttpServletResponse response){
		   User user =  new User();
	       String username = request.getParameter("username");
	       String password = request.getParameter("password");
	       
	       user.setPassword(password);
	       user.setUsername(username);
	       UserServiceImp userServiceImp = new UserServiceImp();
	       //boolean username_exit;
	       boolean login;
		try {
			//username_exit = userServiceImp.checkName(username);
			login = userServiceImp.login(user);
			 if(login) {
				 //Cookie cookie = new Cookie("username", username);
				 Cookie cookie = new Cookie("username", URLEncoder.encode(username,"UTF-8"));
				 cookie.setMaxAge(24*60*60);
				 cookie.setDomain("localhost");
				 cookie.setPath("/");
				 response.addCookie(cookie);
				 response.sendRedirect("../index.jsp");
		    	  }else{
		    		  String mess = "用户名与密码不匹配!!!";
		    		  request.getRequestDispatcher("../user/login.jsp?mess="+mess).forward(request, response);
		    		  
		    	  }
		      
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//注销应该把cookie中的用户名删除，并且把session中的购物车信息删除，最好不要用invalid方法，这样会把整个session注销掉
		HttpSession session = request.getSession();
		session.removeAttribute("car");
		//cookie中的用户名删除
		Cookie [] cookies = request.getCookies();
		for(int i = 0;i<cookies.length;i++){
			if(cookies[i].getName().equals("username"));
			    cookies[i].setValue(null);
			    cookies[i].setPath("/");
			    cookies[i].setMaxAge(0);
			    response.addCookie(cookies[i]);  
			    
		}
		
		 response.sendRedirect("../index.jsp");
		
		
		
		
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
