package com.suresh.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suresh.utils.SUtils;

/**
 * Servlet implementation class DownloadFile
 */
@WebServlet("/downloadFile.do")
public class DownloadFile extends HttpServlet
{
	private static final long	serialVersionUID	= 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadFile()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		startDownload(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
	
	public void startDownload(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException
	{
		String fName = request.getParameter("fileName");
		
		File file = new File(fName);
		System.out.println("file name: " + file.getName());
		FileInputStream fileInputStream = null;
		try
		{
			fileInputStream = new FileInputStream(SUtils.rootPath + File.separator + file.getName());
			ServletContext context = getServletContext();
			// gets MIME type of the file
			String mimeType = context.getMimeType(fName);
			if (mimeType == null)
			{
				// set to binary type if MIME mapping not found
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);
			response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
			OutputStream outStream = response.getOutputStream();
			
			byte[] buffer = new byte[4096];
			int bytesRead = 0;
			while ((bytesRead = fileInputStream.read(buffer)) != -1)
			{
				outStream.write(buffer, 0, bytesRead);
			}
			outStream.flush();
		}
		finally
		{
			if (fileInputStream != null)
				fileInputStream.close();
		}
	}
}