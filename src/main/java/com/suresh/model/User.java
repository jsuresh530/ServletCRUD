package com.suresh.model;

import java.util.Date;

/**
 * @author Suresh Babu J
 *
 */
public class User
{
	/**
	 * 
	 */
	private int					userid;
	private String				firstName;
	private String				lastName;
	private Date				dob;
	private String				email;
	
	public User()
	{}
	
	public int getUserid()
	{
		return userid;
	}
	
	public void setUserid(int userid)
	{
		this.userid = userid;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public Date getDob()
	{
		return dob;
	}
	
	public void setDob(Date dob)
	{
		this.dob = dob;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	/*public static void main(String[] args) {
		System.out.println(System.getProperty("user.name"));
	}*/
}
