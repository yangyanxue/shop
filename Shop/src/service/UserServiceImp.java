package service;

import java.util.ArrayList;

import model.User;
import dao.UserDaoImp;

public class UserServiceImp implements UserService{

	public boolean region(User user) throws Throwable {
		// TODO Auto-generated method stub
		UserDaoImp up = new UserDaoImp();
		int i = up.insertUser(user);
		if(i>0){
			return true;
		}else{
			return false;
		}
		
	}

	public boolean checkName(String username) throws Throwable {
		// TODO Auto-generated method stub
		UserDaoImp up = new UserDaoImp();
		ArrayList al = up.searchUser(username);
		
		if(al.size()>0){
			return true;
		}else{
			return false;
		}
		
	}

	public boolean login(User user) throws Throwable {
		// TODO Auto-generated method stub
		UserDaoImp up = new UserDaoImp();
		ArrayList al = up.searchUser(user.getUsername());
		if(al.size()>0){
			User user1 = (User)al.get(0);
			
			if((user.getPassword()).equals(user1.getPassword())){
				return true;
			}
		}
		return false;
		
	}
	
	

}
