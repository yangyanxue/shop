package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redis.clients.jedis.Jedis;
import service.GoodsServiceImp;
import service.RedisToCart;
import util.JEDIS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.runtime.Name;

import model.CartItem;
import model.Goods;

import dao.GoodsDaoImp;

public class SearchGoods extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList al = new ArrayList();
	Jedis j = new Jedis("localhost",6379);

	/**
	 * Constructor of the object.
	 */
	public SearchGoods() {
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
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if(action.equals("SearchGoods")){
			this.SearchGoods(request,response);
		}
		if(action.equals("addCar")){
			this.addCar(request, response);
		}
		
		
		
	}
	public void SearchGoods(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name = request.getParameter("name");
        GoodsServiceImp  g = new GoodsServiceImp();
		al = g.serchGoodsByName(name);
		request.setAttribute("goods", al);
		request.getRequestDispatcher("../goods/display_goods.jsp").forward(request, response);
		
		
	}
	public void addCar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String goodid = request.getParameter("goodid");
       // GoodsServiceImp  g = new GoodsServiceImp();
		//Goods good = g.serchGoodsByID(Integer.parseInt(goodid));
		
//		HttpSession session =  request.getSession();
//		ArrayList<Goods> list = (ArrayList<Goods>)session.getAttribute("car");
//		if(list == null){
//			list = new ArrayList<Goods>();
//		}
//		list.add(good);
//		session.setAttribute("car", list);
		request.setAttribute("goods", al);
		
		String username = null; 
		//从cookie中获取用户名作为redis hash存储的key,商品ID作为field，cart对象作为value值，需要json化；
		Cookie [] cookies = request.getCookies();
		for(int i = 0;i<cookies.length;i++){
			if(cookies[i].getName().equals("username")){
				username = cookies[i].getValue();
			}
		}
		//RedisToCart r =  new RedisToCart();
		int id = Integer.parseInt(goodid);
		RedisToCart.addToCart(username,id);
		request.getRequestDispatcher("../goods/display_goods.jsp").forward(request, response);
		
		
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
