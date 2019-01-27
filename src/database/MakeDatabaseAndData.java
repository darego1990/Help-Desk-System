// Craig Hogan X00075734

package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;


import model.*;


public class MakeDatabaseAndData
{
	//Fields
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private Statement currvalStatement = null;
	private DBConnection db;
	private ResultSet rset;
	
	int userID = 0;
	int ticketID = 0;
	

    //constructor
	public MakeDatabaseAndData ( )
	{
		db = new DBConnection ( );
		conn = db.openDB ( );
	}


    //methods
	public void getNextFreeUserID ( )
	{
		
		try
		{
			String sql_currval = "SELECT id_seqUser.CURRVAL FROM dual";
			currvalStatement = conn.createStatement ( );
			rset = currvalStatement.executeQuery (sql_currval);
			while (rset.next ( ))
			{
				userID = rset.getInt (1);
			}
		}
		catch (SQLException e)
		{

		}
		User.nextUserID = userID + 1;
		

	}

	
	
	public void getNextFreeTicketID(){
		
		try
		{
			String sql_currval = "SELECT id_seqTicket.CURRVAL FROM dual";
			currvalStatement = conn.createStatement ( );
			rset = currvalStatement.executeQuery (sql_currval);
			while (rset.next ( ))
			{
				ticketID = rset.getInt (1);
			}
		}
		catch (SQLException e)
		{

		}
		
		Ticket.nextTicketID = ticketID + 1;
	}
	
	
	/****** drop tables ******/

	public void dropTables ( )
	{
		try
		{
			String dropUser = "drop table SysteUser";
			String dropTicket = "drop table Ticket";


			stmt = conn.prepareStatement (dropUser);
			stmt.executeUpdate ( );

			stmt = conn.prepareStatement (dropTicket);
			stmt.executeUpdate ( );


		}

		catch (SQLException e)
		{
			JOptionPane.showMessageDialog (null, "Droping of tables failed");
			
		}
		 
	}

     
	/******* create tables *******/
	public void createTables ( )
	{
		try
		{
			String createTicket = "CREATE TABLE Ticket "+" (ticketID integer, "+" ticketName varchar(60), "+"userID integer,"+" status varchar(10),"+"priority integer,"+" dateCreated varchar(25),"+" dateClosed varchar(25),"+" conversation varchar(244))";
			stmt = conn.prepareStatement (createTicket);
			stmt.executeUpdate ( );
			

			
			
			String createUser = "CREATE TABLE SysteUser"+" (userID integer,"+"userName varchar(40),"+"userPassword varchar(15),"+"securityQuestion varchar(60),"+"securityAnswer varchar(20),"+"adminRights smallInt,"+"email varchar(50),"+"fName varchar(20),"+"phoneNumber varchar(20),"+"department varchar(20))";
			stmt = conn.prepareStatement (createUser);
			stmt.executeUpdate ( );
			

		}

		catch (SQLException e)
		{
			JOptionPane.showMessageDialog (null, "Creation of tables failed");
		}
		 
	}

	/***** add data ******/
	public void addDataToTicketTable ( )
	{
		try
		{
			String insertString = "INSERT INTO Ticket (ticketID, ticketName, userID, status, priority, dateCreated, dateClosed, conversation) VALUES (1, 'My moodle account wont work', 1, 'Open', 5, '24-10-2013', '28-10-2013', 'convo')";
			stmt = conn.prepareStatement (insertString);
			stmt.executeUpdate ( );
			StaticFields.nextTicketID++;
			
			String insertString2 = "INSERT INTO Ticket (ticketID, ticketName, userID, status, priority, dateCreated, dateClosed, conversation) VALUES (2, 'My college account wont login', 1,  'Open', 4, '25-10-2013', '29-10-2013', 'convo')";
			stmt = conn.prepareStatement (insertString2);
			stmt.executeUpdate ( );
			StaticFields.nextTicketID ++;
			
			String insertString3 = "INSERT INTO Ticket (ticketID, ticketName, userID, status, priority, dateCreated, dateClosed, conversation) VALUES (3, 'My moodle account wont login', 2,  'Open', 5, '27-10-2013', '29-11-2013', 'convo')";
			stmt = conn.prepareStatement (insertString3);
			stmt.executeUpdate ( );
			StaticFields.nextTicketID ++;
			
			String insertString4 = "INSERT INTO Ticket (ticketID, ticketName, userID, status, priority, dateCreated, dateClosed, conversation) VALUES (4, 'My college account wont login', 2,  'Open', 4, '27-10-2013', '4-11-2013', 'convo')";
			stmt = conn.prepareStatement (insertString4);
			stmt.executeUpdate ( );
			StaticFields.nextTicketID ++;
			
			String insertString5 = "INSERT INTO Ticket (ticketID, ticketName, userID, status, priority, dateCreated, dateClosed, conversation) VALUES (5, 'My moodle account wont login', 3,  'Open', 5, '27-10-2013', '8-11-2013', 'convo')";
			stmt = conn.prepareStatement (insertString5);
			stmt.executeUpdate ( );
			StaticFields.nextTicketID ++;
			
			String insertString6 = "INSERT INTO Ticket (ticketID, ticketName, userID, status, priority, dateCreated, dateClosed, conversation) VALUES (6, 'My college account wont login', 3,  'Open', 4, '27-10-2013', '2-11-2013', 'convo')";
			stmt = conn.prepareStatement (insertString6);
			stmt.executeUpdate ( );
			StaticFields.nextTicketID ++;
			
			String insertString7 = "INSERT INTO Ticket (ticketID, ticketName, userID, status, priority, dateCreated, dateClosed, conversation) VALUES (7, 'My moodle account wont login', 4,  'Open', 5, '27-10-2013', '15-11-2013', 'convo')";
			stmt = conn.prepareStatement (insertString7);
			stmt.executeUpdate ( );
			StaticFields.nextTicketID ++;
			
			String insertString8 = "INSERT INTO Ticket (ticketID, ticketName, userID, status, priority, dateCreated, dateClosed, conversation) VALUES (8, 'My college account wont login', 4,  'Open', 4, '27-10-2013', '9-11-2013', 'convo')";
			stmt = conn.prepareStatement (insertString8);
			stmt.executeUpdate ( );
			StaticFields.nextTicketID ++;



		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog (null, "data added fail 1");
		}
		 

	}

	public void addDataToSysteUserTable ( )
	{
		try
		{
			String insertString = "INSERT INTO SysteUser (userID,userName,userPassword,securityQuestion,securityAnswer,adminRights,email,fName,phoneNumber,department) VALUES (1,'craig','craig','mothers maiden name?','whelan',1,'craighogan@ittd.ie','craig hogan','0858435650','computing')";
			stmt = conn.prepareStatement (insertString);
			stmt.executeUpdate ( );
			StaticFields.nextUserID ++;
			
			String insertString2 = "INSERT INTO SysteUser (userID,userName,userPassword,securityQuestion,securityAnswer,adminRights,email,fName,phoneNumber,department) VALUES (2,'john','john','dogs name?','rex',0,'johnd@ittd.ie','john doe','08584578657','business')";
			stmt = conn.prepareStatement (insertString2);
			stmt.executeUpdate ( );
			StaticFields.nextUserID ++;
			
			String insertString3 = "INSERT INTO SysteUser (userID,userName,userPassword,securityQuestion,securityAnswer,adminRights,email,fName,phoneNumber,department) VALUES (3,'rosie','rosie','dogs name?','jimmy',1,'rosie@ittd.ie','rosie fallon','08577777557','science')";
			stmt = conn.prepareStatement (insertString3);
			stmt.executeUpdate ( );
			StaticFields.nextUserID ++;
			
			String insertString4 = "INSERT INTO SysteUser (userID,userName,userPassword,securityQuestion,securityAnswer,adminRights,email,fName,phoneNumber,department) VALUES (4,'david','david','mothers maiden name?','fallon',0,'david@ittd.ie','david doe','0858999999','marketing')";
			stmt = conn.prepareStatement (insertString4);
			stmt.executeUpdate ( );
			StaticFields.nextUserID ++;


		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog (null, "data added fail");
		}
		 

	}

	
	public void closeConn(){
		db.closeDB ( );
	}

	
}