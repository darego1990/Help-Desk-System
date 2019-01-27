// Craig Hogan X00075734

package model;

public class Ticket {
		
		private int ticketID;
		private String ticketName;
		private String status;
		private int priority;
		private String dateCreated;
		private String dateClosed;
		private String conversation;
		
		public static int nextTicketID;
		
		public Ticket(int ticketID, String ticketName, String status, int priority, String dateCreated, String dateClosed, String conversation)
		{
			this.ticketID = ticketID;
			this.ticketName = ticketName;
			this.status = status;
			this.priority = priority;
			this.dateClosed = dateClosed;
			this.dateCreated = dateCreated;
			this.conversation = conversation;
		}

		public int getUser ( )
		{
			return ticketID;
		}
		public int getTicketID ( )
		{
			return ticketID;
		}

		public void setTicketID (String ticketName)
		{
			this.ticketName = ticketName;
		}
		public String getTicketName ( )
		{
			return ticketName;
		}

		public void setTicketName (String ticketName)
		{
			this.ticketName = ticketName;
		}
		
		public String getStatus ( )
		{
			return status;
		}

		public void setStatus (String status)
		{
			this.status = status;
		}
		public int getPriority ( )
		{
			return priority;
		}

		public void setPriority (int priority)
		{
			this.priority = priority;
		}
		public String getDateCreated ( )
		{
			return dateCreated;
		}

		public void setDateCreated (String dateCreated)
		{
			this.dateCreated = dateCreated;
		}
		public String getDateClosed ( )
		{
			return dateClosed;
		}

		public void setDateClosed (String dateClosed)
		{
			this.dateClosed = dateClosed;
		}
		public String getConversation ( )
		{
			return conversation;
		}

		public void setConversation (String conversation)
		{
			this.conversation = conversation;
		}
	

	}

