package dao;

import java.util.ArrayList;

import model.User;

public interface UserDao {
	 int insertUser(User user) throws Throwable;
	 ArrayList  searchUser(String username)throws Throwable;

}
