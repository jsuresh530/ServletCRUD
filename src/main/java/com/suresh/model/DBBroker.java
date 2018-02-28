package com.suresh.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

public class DBBroker extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3848185688710552684L;
	
	private static DataSource datasource = null;
	
	/**
	   * Setup our connection pool when this servlet is started.
	   * Note that this servlet must be started before any other servlet that tries to
	   * use our database connections.
	   */
	  public void init() throws ServletException
	  {
		  System.err.println("*** I am in init  ");
	    try
	    {
	      InitialContext initialContext = new InitialContext();
	      
	      System.out.println("initial context : "+initialContext);
	      if (initialContext == null )
	      {
	        String message = "There was no InitialContext in DBBroker. We're about to have some problems.";
	        System.err.println("*** " + message);
	        throw new Exception(message);
	      }

	      // actual jndi name is "jdbc/postgres"
	      datasource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/ServletCRUD");

	      if ( datasource == null )
	      {
	        String message = "Could not find our DataSource in DBBroker. We're about to have problems.";
	        System.err.println("*** " + message);
	        throw new Exception(message);
	      }
	    }
	    catch (Exception e)
	    {
	      throw new ServletException(e.getMessage());
	    }
	  }

	  /**
	   * Dole out the connections here.
	   */
	  public static synchronized Connection getConnection() throws SQLException
	  {
	    return datasource.getConnection();
	  }

	  /**
	   * Must close the database connection to return it to the pool.
	   */
	  public static synchronized void freeConnection(Connection connection)
	  {
	    try
	    {
	      connection.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("DBBroker: Threw an exception closing a database connection "+e.getMessage());
	    }
	  }

}
