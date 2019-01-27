// Craig Hogan X00075734

package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import gui.*;
import model.*;

import javax.swing.JOptionPane;

public class UserOperations
{
	private Connection conn = null;
	private ResultSet rset = null;
	private PreparedStatement stmt = null;
	private DBConnection db;

	/******* Fields **********/

	/****** Constructor ******/
	public UserOperations ( )
	{
		db = new DBConnection ( );
		conn = db.openDB ( );

	}


	/****** Methods 
	 * @return ********/
	
	
	  public ResultSet validateLog(String username, String userpassword)
	  {
	      try {
	          String sql = "SELECT userid, username, userpassword, securityquestion, securityanswer, adminrights, email, fname, phonenumber, department FROM systeuser WHERE username = ? AND userpassword = ?";

	          stmt = conn.prepareStatement(sql);
	          stmt.setString (1, username);
	          stmt.setString (2, userpassword);
	          rset = stmt.executeQuery ( );

	      }
	      catch(Exception e){
	          e.printStackTrace ( );
	          JOptionPane.showMessageDialog (null, "Login Failed", null, JOptionPane.WARNING_MESSAGE);
	      }
	      return rset;

	  }
	  public void createAccount(String userName, String userPassword, String securityQuestion, String securityAnswer, String email, String fName, String phoneNumber, String department)
	  {
	      try {
	          String sql = "INSERT INTO SysteUser (userid,username,userpassword,securityquestion,securityanswer,adminrights,email,fname,phonenumber,department) VALUES (?,?,?,?,?,?,?,?,?,?)";
	          stmt = conn.prepareStatement(sql);
	          stmt.setInt (1, StaticFields.getNextUserID());
	          stmt.setString (2, userName);
	          stmt.setString (3, userPassword);
	          stmt.setString (4, securityQuestion);
	          stmt.setString (5, securityAnswer);
	          stmt.setInt (6, 1);
	          stmt.setString (7, email);
	          stmt.setString (8, fName);
	          stmt.setString (9, phoneNumber);
	          stmt.setString (10, department);
	          stmt.executeQuery ( );
	          StaticFields.nextUserID ++;

	      }
	      catch(Exception e){
	          e.printStackTrace ( );
	          JOptionPane.showMessageDialog (null, "createAccount failed", null, JOptionPane.WARNING_MESSAGE);
	      }

	  }
	  public void createUserAccount(String userName, String userPassword, String securityQuestion, String securityAnswer, String email, String fName, String phoneNumber, String department)
	  {
	      try {
	          String sql = "INSERT INTO SysteUser (userid,username,userpassword,securityquestion,securityanswer,adminrights,email,fname,phonenumber,department) VALUES (?,?,?,?,?,?,?,?,?,?)";
	          stmt = conn.prepareStatement(sql);
	          stmt.setInt (1, StaticFields.getNextUserID());
	          stmt.setString (2, userName);
	          stmt.setString (3, userPassword);
	          stmt.setString (4, securityQuestion);
	          stmt.setString (5, securityAnswer);
	          stmt.setInt (6, 0);
	          stmt.setString (7, email);
	          stmt.setString (8, fName);
	          stmt.setString (9, phoneNumber);
	          stmt.setString (10, department);
	          stmt.executeQuery ( );

	      }
	      catch(Exception e){
	          e.printStackTrace ( );
	          JOptionPane.showMessageDialog (null, "createAccount failed", null, JOptionPane.WARNING_MESSAGE);
	      }

	  }
	  
	  public ResultSet validateAcccount(String username, String userpassword)
	  {
	      try {
	          String sql = "SELECT * FROM systeuser WHERE username = ? AND userpassword = ?";

	          stmt = conn.prepareStatement(sql);
	          stmt.setString (1, username);
	          stmt.setString (2, userpassword);
	          rset = stmt.executeQuery ( );

	      }
	      catch(Exception e){
	          e.printStackTrace ( );
	          JOptionPane.showMessageDialog (null, "Login Failed", null, JOptionPane.WARNING_MESSAGE);
	      }
	      return rset;

	  }
	  
	
	  public void updateUser (String username, String userPassword, String securityQuestion, String securityAnswer, String email, String fName, String phoneNumber, String department)
		{
			
			try
			{
				String sql = "UPDATE systeuser SET userpassword = ?,securityquestion = ?,securityanswer = ?,email = ?,fname = ?,phonenumber = ?,department = ? WHERE username = ?";
		          stmt = conn.prepareStatement(sql);
		          stmt.setString (1, userPassword);
		          stmt.setString (2, securityQuestion);
		          stmt.setString (3, securityAnswer);
		          stmt.setString (4, email);
		          stmt.setString (5, fName);
		          stmt.setString (6, phoneNumber);
		          stmt.setString (7, department);
		          stmt.setString (8, username);
		          stmt.executeUpdate( );
			}
			catch (Exception e)
			{
				e.printStackTrace ( );

			}

		}
	
	
	public void closeConn ( )
	{
		if (rset != null)
		{
			try
			{
				rset.close ( );
			}
			catch (Exception e)
			{

			}
			rset = null;
		}
		if (stmt != null)
		{
			try
			{
				stmt.close ( );
			}
			catch (Exception e)
			{

			}
			stmt = null;

		}
		if (conn != null)
		{
			try
			{
				conn.close ( );
			}
			catch (Exception e)
			{

			}
			conn = null;
		}

	}




}

