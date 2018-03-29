package com.bo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class RequestBO
{
	@XmlElement(name = "eventId")
	private String	eventId;
	@XmlElement(name = "eventCallId")
	private String	eventCallId;
	private String	redirectMsg;
	private String	secretCode;
	
	private String	userId;
	
	public String getEventId()
	{
		return eventId;
	}
	
	public void setEventId(String eventId)
	{
		this.eventId = eventId;
	}
	
	public String getEventCallId()
	{
		return eventCallId;
	}
	
	public void setEventCallId(String eventCallId)
	{
		this.eventCallId = eventCallId;
	}
	
	public String getRedirectMsg()
	{
		return redirectMsg;
	}
	
	public void setRedirectMsg(String redirectMsg)
	{
		this.redirectMsg = redirectMsg;
	}
	
	public String getSecretCode()
	{
		return secretCode;
	}
	
	public void setSecretCode(String secretCode)
	{
		this.secretCode = secretCode;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
}
