package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.FilterChain;




public class shopFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HttpServletRequest request = (HttpServletRequest) servletRequest;
	     HttpServletResponse response = (HttpServletResponse) servletResponse;
	     response.setHeader("content-type", "text/html;charset=UTF-8");  
		 response.setCharacterEncoding("UTF-8");  
		 request.setCharacterEncoding("UTF-8"); 
	     String returnUrl = request.getContextPath() + "/user/login.jsp";  
		 Cookie[] cookies = request.getCookies();
		 PrintWriter pw = response.getWriter();
		 boolean flag=false;
		 String action = request.getParameter("action");
		 if(action.equals("addCar")){
			for(int i = 0;i<cookies.length;i++){
				if(cookies[i].getName().equals("username")){
					flag=true;
				}
			}
			if(flag == false){
				 pw.println(  
	                     "<script language=\"javascript\">alert(\"您还没有登录，请先登录!\");if(window.opener==null){window.top.location.href=\""  
	                             + returnUrl  
	                             + "\";}else{window.opener.top.location.href=\""  
	                             + returnUrl  
	                             + "\";window.close();}</script>");  
				return;
			}else{
				filterChain.doFilter(servletRequest, servletResponse);
				return;
			}
			
		}else{
			filterChain.doFilter(servletRequest, servletResponse);
			return;
			
		}
		
		 
		

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
