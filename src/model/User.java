// Craig Hogan X00075734

package model;

public class User
{
	private int userID;
	private String userName;
	private String userPassword;
	private int adminRights;
	private String securityQuestion;
	private String securityAnswer;
	private String email;
	private String fullName;
	private String phoneNumber;
	private String department;
	
	public static int nextUserID;

	public User (int userID, String userName, String userPassword, String securityQuestion, String securityAnswer, int adminRights, String email, String fullName, String phoneNumber, String department)
	{
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.adminRights = adminRights;
		
		this.email = email;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.department = department;
	}
	

	public String getfullName ( )
	{
		return fullName;
	}
	public int getUserID ( )
	{
		return userID;
	}

	public void setUserID (int userID)
	{
		this.userID = userID;
	}

	public String getUserName ( )
	{
		return userName;
	}

	public void setUserName (String userName)
	{
		this.userName = userName;
	}

	public String getUserPassword ( )
	{
		return userPassword;
	}

	public void setUserPassword (String userPassword)
	{
		this.userPassword = userPassword;
	}

	public String getSecurityQuestion ( )
	{
		return securityQuestion;
	}

	public void setSecurityQuestion (String securityQuestion)
	{
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer ( )
	{
		return securityAnswer;
	}

	public void setSecurityAnswer (String securityAnswer)
	{
		this.securityAnswer = securityAnswer;
	}

	public int isAdminRights ( )
	{
		return adminRights;
	}

	public void setAdminRights (int adminRights)
	{
		this.adminRights = adminRights;
	}
	public String getEmail ( )
	{
		return email;
	}
	public void setEmail (String email)
	{
		this.email = email;
	}
	public String getName ( )
	{
		return fullName;
	}
	public void setName (String fullName)
	{
		this.fullName = fullName;
	}
	
	public String getPhoneNumber ( )
	{
		return phoneNumber;
	}
	public void setPhoneNumber (String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public String getDepartment ( )
	{
		return department;
	}
	public void setDepartment (String department)
	{
		this.department = department;
	}


}
