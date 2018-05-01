package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.CartItem;
import model.Goods;
import redis.clients.jedis.Jedis;
import util.JEDIS;

public class RedisToCart {
	public RedisToCart(){
		
	}
	public static void addToCart(String username,int id){
		
		Jedis j = JEDIS.connection();
		String value = j.hget(username, String.valueOf(id));
		
		CartItem c = null;
		ObjectMapper mapper = new ObjectMapper();
		//如果redis中没有添加过该商品，需要把该商品添加到redis
		try{
			if(value == null){
				GoodsServiceImp g = new GoodsServiceImp();
				Goods  goods = g.serchGoodsByID(id);
				
				c =new CartItem();
				c.setId(id);
				c.setName(goods.getName());
				c.setNow_price(goods.getNow_price());
				c.setImages(goods.getImages());
				c.setSize(goods.getSize());
				c.setColor(goods.getColor());
				c.setCount(1);
			 }else{
			//如果redis中已经添加过该商品，只需要把该商品中的num+1	
				c =  mapper.readValue(value, CartItem.class);
			    c.setCount(c.getCount()+1);
				
			}
		    j.hset(username, String.valueOf(id),mapper.writeValueAsString(c));
		    
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.toString();
		}
		
		
	}
	public static ArrayList<CartItem> getCart(String username){
		if(username == null){
			return null;
		}
		
		ArrayList<CartItem> al =  new ArrayList<CartItem>();
		ObjectMapper mapper = new ObjectMapper();
		Jedis j = JEDIS.connection();
		try {
		Map<String, String> map = j.hgetAll(username);
		for(String value: map.values()){
			
			CartItem cartItem = mapper.readValue(value, CartItem.class);
			al.add(cartItem);
			}
		}
		catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return al;
		}
	
	
	}


