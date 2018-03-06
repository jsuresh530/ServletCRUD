package com.suresh.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suresh.constants.Constants;
import com.suresh.model.User;
import com.suresh.service.UserServiceImpl;
import com.suresh.utils.DBUtil;

/**
 * @author Suresh Babu J
 *
 */
public class UserDAOImpl implements UserDAO, Constants
{
	private static final Logger	logger				= LoggerFactory.getLogger(UserServiceImpl.class);
	private Connection			connection			= null;
	private PreparedStatement	preparedStatement	= null;
	
	/*private UserDAOImpl()
	{
		connection = DBUtil.getConnection();
	}*/
	
	@Override
	public int addUser(User user)
	{
		logger.info("Entry into addUser method ");
		int result = 0;
		try
		{
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("insert into users(firstname,lastname,dob,email,userTypeId,password) values (?, ?, ?, ?,?,? )");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setInt(5, NUMBER_TWO);
			preparedStatement.setString(6, user.getPassword());
			
			result = preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			logger.error("Exception " + e.getMessage());
		}
		finally
		{
			DBUtil.shutConnection(connection);
		}
		logger.info("Exit from addUser method COUNT : {}", result);
		return result;
	}
	
	@Override
	public int deleteUser(int userId)
	{
		logger.info("Entry into deleteUser method , userId " + userId);
		int result = 0;
		try
		{
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("delete from users where userid =?");
			preparedStatement.setInt(1, userId);
			
			result = preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			logger.error("Exception ", e.getCause());
		}
		finally
		{
			DBUtil.shutConnection(connection);
		}
		logger.info("Exit from deleteUser method COUNT : {}", result);
		return result;
	}
	
	@Override
	public int updateUser(User user)
	{
		logger.info(" Entry into updateUser method ");
		int executeUpdate = 0;
		try
		{
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("update users set firstname=?, lastname=?, dob=?, email=? where userid=?");
			
			// Parameters start with 1
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setInt(5, user.getUserid());
			executeUpdate = preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			logger.error("Exception ", e.getCause());
		}
		finally
		{
			DBUtil.shutConnection(connection);
		}
		logger.info("Exit from updateUser method COUNT : {} ", executeUpdate);
		return executeUpdate;
	}
	
	@Override
	public List<User> getAllUsers()
	{
		logger.info("Entry into getAllUsers method ");
		List<User> users = new ArrayList<User>();
		User user = null;
		ResultSet resultSet = null;
		try
		{
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("select * from users");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				user = new User();
				user.setUserid(resultSet.getInt("userid"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setDob(resultSet.getDate("dob"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setUserTypeId(resultSet.getInt("userTypeId"));
				users.add(user);
			}
		}
		catch (SQLException e)
		{
			logger.error("Exception ", e.getCause());
		}
		finally
		{
			try
			{
				DBUtil.shutConnection(connection);
				if(resultSet != null)
				resultSet.close();
			}
			catch (SQLException e)
			{
				logger.error("Exception " + e.getCause());
			}
		}
		logger.info("Exit from getAllUsers method LIST SIZE: {}", users.size());
		return users;
	}
	
	@Override
	public User getUserById(int userId)
	{
		logger.info("Entry into getUserById method ", userId);
		User user = new User();
		ResultSet resultSet = null;
		try
		{
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("select * from users where userid = ?");
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setDob(resultSet.getDate("dob"));
				user.setEmail(resultSet.getString("email"));
			}
		}
		catch (SQLException e)
		{
			logger.error("Exception " + e.getCause());
		}
		finally
		{
			try
			{
				DBUtil.shutConnection(connection);
				if(resultSet != null)
				resultSet.close();
				//DbUtils.close(resultSet);
			}
			catch (SQLException e)
			{
				logger.error("Exception " + e.getCause());
			}
		}
		logger.info("Exit from getUserById method {} ", user.getFirstName());
		return user;
	}
	
	@Override
	public int getUserTypeID(String email, String password)
	{
		logger.info("Entry into getUserTypeID method "+email+" "+password);
		int userTypeId = 0;
		ResultSet resultSet =null;
		
		try
		{
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("select userTypeId from users where email = ? and password = ?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				userTypeId = resultSet.getInt("userTypeId");
			}
		}
		catch (SQLException e)
		{
			logger.error("Exception " + e.getCause());
		}
		finally
		{
			try
			{
				DBUtil.shutConnection(connection);
				if(resultSet != null)
				resultSet.close();
				//DbUtils.close(resultSet);
			}
			catch (SQLException e)
			{
				logger.error("Exception " + e.getCause());
			}
		}
		logger.info("Exit into getUserTypeID method "+userTypeId);
		return userTypeId;
	}
	
}
