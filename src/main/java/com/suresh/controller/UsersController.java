package com.suresh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suresh.model.User;
import com.suresh.service.UserServiceImpl;
import com.suresh.utils.SUtils;

/**
 * Servlet implementation class UsersController
 */
/**
 * @author Suresh babu J
 *
 */
//@MultipartConfig(maxFileSize = 16177215) 
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   	// 100 MB
public class UsersController extends HttpServlet
{
	private static final Logger	logger		= LoggerFactory.getLogger(UsersController.class);
	private static final long	serialVersionUID	= 1L;
	
	private UserServiceImpl		userServiceImpl = new UserServiceImpl();
	
	private static String		INSERT_OR_EDIT		= "/WEB-INF/pages/user.jsp";
	private static String		LIST_USER			= "/WEB-INF/pages/listUser.jsp";
	private static String		LOGIN			= "/WEB-INF/pages/login.jsp";
	
	public UsersController()
	{
		super();
		//userServiceImpl = new UserServiceImpl();
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
			String firstName = request.getParameter("firstName");
			user.setFirstName(firstName);
			user.setLastName(request.getParameter("lastName"));
			//https://jqueryui.com/resources/demos/datepicker/date-formats.html
			
			System.out.println(request.getParameter("dob"));
			user.setDob(request.getParameter("dob"));
			
			user.setEmail(request.getParameter("email"));
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
				user.setPassword(request.getParameter("password"));
				File fileSaveDir = new File(SUtils.rootPath);
				
				if (!fileSaveDir.exists()) {
		            fileSaveDir.mkdirs();
		        }
		        String saveToDB = null;
		        String fileToDB = null;
				
		        for (Part pp : request.getParts())
				{
					String name = SUtils.getFileName(pp);
					name = new File(name).getName();
					
					if(name != null && name.trim().length() > 1)
					{
						fileToDB = name;
						saveToDB = SUtils.rootPath + File.separator + name;
						pp.write(saveToDB);
					}
					
				}
				user.setFileName(fileToDB);
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
		catch (Exception e)
		{
			logger.info("Exception ", e.getMessage());
		}
		
	}
	
}
