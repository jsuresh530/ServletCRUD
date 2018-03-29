package com.suresh.model;


/**
 * @author Suresh Babu J
 *
 */
public class User
{
	/**
	 * 
	 */
	private int		userid;
	private String	firstName;
	private String	lastName;
	private String	dob;
	private String	email;
	private int	userTypeId;
	private String fileName;
	
	private String	password;
	
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
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

	public int getUserTypeId()
	{
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId)
	{
		this.userTypeId = userTypeId;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("User [userid=");
		builder.append(userid);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", dob=");
		builder.append(getDob());
		builder.append(", email=");
		builder.append(email);
		builder.append(", userTypeId=");
		builder.append(userTypeId);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

	public String getDob()
	{
		return dob;
	}

	public void setDob(String dob)
	{
		this.dob = dob;
	}

}
