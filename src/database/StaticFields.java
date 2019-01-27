// Craig Hogan X00075734

package database;

public class StaticFields 
{
	public static int nextUserID;
	public static int nextTicketID;
	
	public static int getNextUserID()
	{
		return nextUserID+1;
	}
	public static int getNextTicketID()
	{
		return nextTicketID+1;
	}
}
