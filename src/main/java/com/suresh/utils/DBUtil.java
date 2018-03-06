package com.suresh.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Suresh babu J
 *
 */
public class DBUtil
{
	private static final Logger	logger		= LoggerFactory.getLogger(DBUtil.class);
	private static Connection	connection	= null;
	
	public static void shutConnection(Connection connection)
	{
		if(connection != null)
		{
			try
			{
				connection.close();
			}
			catch (SQLException e)
			{
				logger.error("Inside shutConnection() method.");
			}
		}
	}
	public static Connection getConnection()
	{
		logger.info("Inside getConnection() method.");
		InputStream resourceAsStream = null;
		Properties prop = new Properties();
		/*if (connection != null)
			return connection;
		else
		{*/
			try
			{
				resourceAsStream = DBUtil.class.getClassLoader().getResourceAsStream("/db.properties");
				prop.load(resourceAsStream);
				
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
				logger.info("Connection established ");
			}
			catch (ClassNotFoundException e)
			{
				logger.error("ERROR."+e.getCause());
			}
			catch (SQLException e)
			{
				logger.error("ERROR."+e.getCause());
			}
			catch (FileNotFoundException e)
			{
				logger.error("ERROR."+e.getCause());
			}
			catch (IOException e)
			{
				logger.error("ERROR."+e.getCause());
			}
		//}
		logger.info("Exit from getConnection() method. ");
		return connection;
	}
}
