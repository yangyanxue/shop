package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JDBCutil;
import model.Goods;
import model.User;

public class GoodsDaoImp implements GoodsDao{
	
	public ArrayList serchGoodsByName(String name) {
		
		ArrayList<Goods> al = new ArrayList<Goods>();
		String sql;
		if((name == null)||(name == "")){
			sql = "select * from goods where name like '%'";
		}else{
			sql = "select * from goods where name like '%"+name+"%'";
		}
		
		Connection conn = JDBCutil.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);  
			ResultSet rs = ps.executeQuery();        
		
			while(rs.next()){              
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setOrignal_price(rs.getInt("orignal_price"));
				goods.setNow_price(rs.getInt("now_price"));
				goods.setStore_num(rs.getInt("store_num"));
				goods.setItem_id(rs.getInt("item_id"));
				goods.setImages(rs.getString("images"));
				goods.setDescription(rs.getString("description"));
				goods.setSize(rs.getString("size"));
				goods.setColor(rs.getString("color"));			
				al.add(goods);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return al;
	}

	public Goods serchGoodsByID(int id) {
		// TODO Auto-generated method stub
		
		String sql;
		sql = "select * from goods where id = "+id;
		Connection conn = JDBCutil.getConnection();
		PreparedStatement ps;
		Goods goods = new Goods();
		try {
			ps = conn.prepareStatement(sql);  
			ResultSet rs = ps.executeQuery();        
			
			while(rs.next()){              
				
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setOrignal_price(rs.getInt("orignal_price"));
				goods.setNow_price(rs.getInt("now_price"));
				goods.setStore_num(rs.getInt("store_num"));
				goods.setItem_id(rs.getInt("item_id"));
				goods.setImages(rs.getString("images"));
				goods.setDescription(rs.getString("description"));
				goods.setSize(rs.getString("size"));
				goods.setColor(rs.getString("color"));			
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return goods;
	}
	}
	
	


