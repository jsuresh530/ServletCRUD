package com.listener;

import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class FileLocationContextListener
 *
 */
@WebListener
public class FileLocationContextListener { //implements ServletContextListener {

	private static final Logger	logger		= LoggerFactory.getLogger(FileLocationContextListener.class);
    /**
     * Default constructor. 
     */
    public FileLocationContextListener() {
        logger.info("In FileLocationContextListener ");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     *//*
    public void contextInitialized(ServletContextEvent sce)  { 
    	logger.info("In contextInitialized ");
    	
    	String rootPath = System.getProperty("catalina.home");
    	ServletContext ctx = sce.getServletContext();
    	String relativePath = ctx.getInitParameter("tempfile.dir");
    	File file = new File(rootPath + File.separator + relativePath);
    	
    	if(!file.exists()) 
    	file.mkdirs();
    	logger.info("File Directory created to be used for storing files ..> "+file);
    	ctx.setAttribute("FILES_DIR_FILE", file);
    	ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);
    	
    }

	*//**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     *//*
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }*/
	
}
