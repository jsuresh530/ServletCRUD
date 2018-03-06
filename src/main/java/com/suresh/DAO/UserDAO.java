package com.suresh.DAO;

import java.util.List;

import com.suresh.model.User;

public interface UserDAO
{
	public int addUser(User user);
	public int deleteUser(int userId);
	public int updateUser(User user);
	public List<User> getAllUsers();
	
	public User getUserById(int userId);
	
	int getUserTypeID(String email, String password);
	
}
