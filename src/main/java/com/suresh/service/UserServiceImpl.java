package com.suresh.service;

import java.util.List;

import com.suresh.DAO.UserDAOImpl;
import com.suresh.model.User;

/**
 * @author Suresh babu J
 *
 */
public class UserServiceImpl implements UserService
{
	UserDAOImpl	daoImpl	= new UserDAOImpl();
	
	@Override
	public int addUser(User user)
	{
		int addUser = daoImpl.addUser(user);
		return addUser;
	}
	
	@Override
	public int deleteUser(int userId)
	{
		int deleteUser = daoImpl.deleteUser(userId);
		return deleteUser;
	}
	
	@Override
	public int updateUser(User user)
	{
		int updateUser = daoImpl.updateUser(user);
		return updateUser;
	}
	
	@Override
	public List<User> getAllUsers()
	{
		List<User> allUsers = daoImpl.getAllUsers();
		return allUsers;
	}
	
	@Override
	public User getUserById(int userId)
	{
		User userById = daoImpl.getUserById(userId);
		return userById;
	}
}
