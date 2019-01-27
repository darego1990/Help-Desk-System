// Craig Hogan X00075734

package database;

import java.sql.*;

import javax.swing.JOptionPane;
import gui.AdminDashboard;
import net.proteanit.sql.DbUtils;

import model.*;

public class TicketOperations 
{
	private Connection conn = null;
	private ResultSet rset = null;
	private PreparedStatement stmt = null;
	private Statement currvalStatement = null;
	private DBConnection db;
	
	Ticket ticket;
	private int ticketID = 0;
	
	public TicketOperations(){
		db = new DBConnection ( );
		conn = db.openDB ( );
	}
	
	public void deleteTicket(int ticketID)
	{
		try {
			String sql = "DELETE FROM ticket WHERE ticketID = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ticketID);
			rset = stmt.executeQuery();
		} 
		catch (Exception e) {
			
		}
		
		
	}
	
	 public ResultSet getTicket(int ticketID)
	  {
	      try {
	          String sql = "SELECT ticketID, ticketName, userID, status, priority, dateCreated, dateClosed, conversation FROM ticket WHERE ticketID = ?";

	          stmt = conn.prepareStatement(sql);
	          stmt.setInt (1, ticketID);
	          rset = stmt.executeQuery ( );

	      }
	      catch(Exception e){
	          e.printStackTrace ( );
	          JOptionPane.showMessageDialog (null, "Login Failed", null, JOptionPane.WARNING_MESSAGE);
	      }
	      return rset;

	  }
	 
	 public void updateTicket (int ticketID, String ticketName, String status, String priority, String dateCreated, String dateClosed, String conversation)
		{
			
			try
			{
				String sql = "UPDATE ticket SET ticketname = ?, status = ?, priority = ?, datecreated = ?, dateClosed = ?, conversation = ? WHERE ticketid = ?";
		          stmt = conn.prepareStatement(sql);
		          stmt.setString (1, ticketName);
		          stmt.setString (2, status);
		          stmt.setString (3, priority);
		          stmt.setString (4, dateCreated);
		          stmt.setString (5, dateClosed);
		          stmt.setString (6, conversation);
		          stmt.setInt (7, ticketID);
		          stmt.executeUpdate( );
			}
			catch (Exception e)
			{
				e.printStackTrace ( );

			}

		}
	 public void createTicket(String ticketName, String conversation, int userID)
	  {
	      try {
	          String sql = "INSERT INTO Ticket (ticketid, ticketname, userid, status, priority, datecreated, dateclosed, conversation) VALUES (?,?,?,'Open',0,'0','0',?)";
	          stmt = conn.prepareStatement(sql);
	          stmt.setInt (1, StaticFields.getNextTicketID());
	          stmt.setString (2, ticketName);
	          stmt.setInt (3, userID);
	          stmt.setString (4, conversation);
	          stmt.executeQuery ( );
	          StaticFields.nextTicketID ++;

	      }
	      catch(Exception e){
	          e.printStackTrace ( );
	          JOptionPane.showMessageDialog (null, "createAccount failed", null, JOptionPane.WARNING_MESSAGE);
	      }

	  }
	
}
