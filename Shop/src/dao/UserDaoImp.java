package dao;

import model.User;
import util.JDBCutil;
import java.sql.*;
import java.util.ArrayList;

import com.sun.crypto.provider.RSACipher;

public class UserDaoImp {
	

	public int insertUser(User user) throws Throwable{
		// TODO Auto-generated method stub
		String sql = "insert into user(username,password,createdtime,telnum)values(?,?,now(),?)";
		Connection conn = JDBCutil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getTelnum());
		int tem = ps.executeUpdate();
		JDBCutil.releaseConn(conn, ps, null);
		return tem;
	}

	public ArrayList searchUser(String username) throws Throwable {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		String sql = "select * from user where username = '"+username+"'";
		Connection conn = JDBCutil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		//ps.setString(1, username);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setTelnum(rs.getString("telnum"));
			al.add(user);
		}
		
		JDBCutil.releaseConn(conn, ps, null);
		
		return al;
		
	}
	public static void main(String[] args) {
		
		try {
			UserDaoImp u = new UserDaoImp();
			User user = new User();
			user.setPassword("12");
			user.setTelnum("121");
			user.setUsername("雪");
			System.out.println(u.insertUser(user));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
