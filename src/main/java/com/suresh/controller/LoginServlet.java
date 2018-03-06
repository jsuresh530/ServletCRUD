package com.suresh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suresh.service.UserServiceImpl;

/**
 * Servlet implementation class WelcomeServlet
 */
//@WebServlet(urlPatterns = "/LoginServlet",loadOnStartup = 1, asyncSupported = true)
public class LoginServlet extends HttpServlet {
	private static final Logger	logger		= LoggerFactory.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;
	private UserServiceImpl		userServiceImpl = null;
	private static String		LIST_USER			= "/WEB-INF/pages/listUser.jsp";
	private static String		LOGIN			= "/WEB-INF/pages/login.jsp";
	private static String		USER_PAGE			= "/WEB-INF/pages/userPage.jsp";
	
	String forward = "";
     //  sdfgssgsg
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	userServiceImpl = new UserServiceImpl();
    	logger.info("I am from LoginServlet");
        //super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entry into  doGet LoginServlet");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entry into  doPost LoginServlet");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		 
		int userTypeID = userServiceImpl.getUserTypeID(email, password);
		
		if(userTypeID == 1)
		{
			forward = LIST_USER;
			request.setAttribute("users", userServiceImpl.getAllUsers());
			request.getSession(true).setAttribute("admin", email);
		}
		else if(userTypeID == 2)
		{
			forward = USER_PAGE;
			request.getSession(true).setAttribute("user", email);
		}
		else
		{
			forward = LOGIN;
		}
		
		//response.sendRedirect("https://www.google.com");
		RequestDispatcher rd =getServletContext().getRequestDispatcher(forward);
		rd.include(request, response);
	}

}
