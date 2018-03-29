package com.bo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ResponseBO
{
	private int		responseCode;
	
	private String	responseMsg;
	
	private String	userId;
	
	private String	emailAddress;
	
	private String	password;
	
	public int getResponseCode()
	{
		return responseCode;
	}
	
	public void setResponseCode(int responseCode)
	{
		this.responseCode = responseCode;
	}
	
	public String getResponseMsg()
	{
		return responseMsg;
	}
	
	public void setResponseMsg(String responseMsg)
	{
		this.responseMsg = responseMsg;
	}
	
	public String getUserId()
	{
		return userId;
	}
	
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
}
