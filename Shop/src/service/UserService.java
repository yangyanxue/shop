package service;

import model.User;

public interface UserService {
	boolean region(User user) throws Throwable;
	boolean checkName(String username)throws Throwable;
	boolean login(User user)throws Throwable;

}
