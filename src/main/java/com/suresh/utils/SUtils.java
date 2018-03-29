package com.suresh.utils;

import java.io.File;

import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suresh.controller.UsersController;

public class SUtils
{
	private static final Logger	logger		= LoggerFactory.getLogger(UsersController.class);
	public static String rootPath = System.getProperty("catalina.home")+ File.separator + "FILES";
	
	
	public static String getFileName(Part part)
	{
		String contentDisp = part.getHeader("content-disposition");
		logger.info("contentDisp ----------> "+contentDisp);
		String[] split = contentDisp.split(";");
		for (String string : split)
		{
			if(string.trim().startsWith("filename"))
			{
				return string.substring(string.indexOf("=") + 2, string.length()-1);
			}
		}
		return "";
	}
}
