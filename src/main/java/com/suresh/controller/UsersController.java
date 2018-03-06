package com.suresh.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suresh.model.User;
import com.suresh.service.UserServiceImpl;

/**
 * Servlet implementation class UsersController
 */
/**
 * @author Suresh babu J
 *
 */
public class UsersController extends HttpServlet
{
	private static final Logger	logger		= LoggerFactory.getLogger(UsersController.class);
	private static final long	serialVersionUID	= 1L;
	
	private UserServiceImpl		userServiceImpl = null;
	
	private static String		INSERT_OR_EDIT		= "/WEB-INF/pages/user.jsp";
	private static String		LIST_USER			= "/WEB-INF/pages/listUser.jsp";
	private static String		LOGIN			= "/WEB-INF/pages/login.jsp";
	
	public UsersController()
	{
		super();
		userServiceImpl = new UserServiceImpl();
		logger.info("Inside UsersController construtor");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		logger.info("Inside doGet ");
		String forward = "";
		String action = request.getParameter("action");
		
		System.out.println("action ::: "+action);
		if (action.equalsIgnoreCase("delete"))
		{
			int userId = Integer.parseInt(request.getParameter("userId"));
			userServiceImpl.deleteUser(userId);
			forward = LIST_USER;
			request.setAttribute("users", userServiceImpl.getAllUsers());
		}
		else if (action.equalsIgnoreCase("edit"))
		{
			forward = INSERT_OR_EDIT;
			int userId = Integer.parseInt(request.getParameter("userId"));
			User user = userServiceImpl.getUserById(userId);
			request.setAttribute("userId", userId);
			request.setAttribute("user", user);
			request.setAttribute("action", action);
		}
		else if (action.equalsIgnoreCase("listUser"))
		{
			forward = LIST_USER;
			request.setAttribute("users", userServiceImpl.getAllUsers());
		}
		else if (action.equalsIgnoreCase("login"))
		{
			request.setAttribute("action", action);
			forward = LOGIN;
		}
		else
		{
			forward = INSERT_OR_EDIT;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		logger.info("Inside doPost ");
		User user = new User();
		int addUser = 0;
		try
		{
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
			user.setDob(dob);
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			//String action = request.getParameter("action");
			String userid = request.getParameter("userId");
			
			if(userid != null && !userid.isEmpty() && Integer.valueOf(userid) > 0)
			{
				user.setUserid(Integer.parseInt(userid));
				userServiceImpl.updateUser(user);
				
				RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
				request.setAttribute("users", userServiceImpl.getAllUsers());
				view.forward(request, response);
			}
			else
			{
				addUser = userServiceImpl.addUser(user);
			}
			
			if(addUser == 1)
			{
				RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
				request.setAttribute("login", "Registration is successful, Please login to your account");
				request.setAttribute("addUser", addUser);
				view.forward(request, response);
			}
			
		}
		catch (ParseException e)
		{
			logger.info("Exception ", e.getCause());
		}
		
	}
	
}
