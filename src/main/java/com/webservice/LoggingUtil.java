package com.webservice;

import org.apache.log4j.Logger;

public class LoggingUtil
{
	private static final Logger	ALOGGER	= Logger.getLogger("aLogger");
	private static final Logger LOG = Logger.getLogger(LoggingUtil.class);
    private static final Logger ILOGGER = Logger.getLogger("iLogger");
	
	public static void writeApplicationLogs(String strng, Class<?> className)
	{
		try
		{
			if (strng != null && !strng.equals(""))
			{
				ALOGGER.info(className + ":" + "application: " + strng);
				writeLogs(strng, "application", className);
			}
		}
		catch (Exception e)
		{
			LOG.error("Exception while writting an application log :: ", e);
		}
		
	}
	
	public static void writeLogs(String msg, String type, Class<?> className)
	{
		try
		{
			if (msg != null && !msg.equals(""))
			{
				ILOGGER.info(className + " : " + type + " : " + msg);
			}
		}
		catch (Exception e)
		{
			LOG.error("Exception while writting an log ::", e);
		}
	}
}
