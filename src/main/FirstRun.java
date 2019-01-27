// Craig Hogan X00075734

package main;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import database.MakeDatabaseAndData;
import gui.*;
import model.*;

/*
 * 
 *   Please make sure both external JARs are properly configured before running!! ojdbc6 and rs2xml, both are located in lib folder
 *
 */

public class FirstRun
{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException 
	{
		// set look and feel
		UIManager.setLookAndFeel(
	    UIManager.getSystemLookAndFeelClassName());
		
		//create main login object
		Login log1 = new Login();
		log1.setVisible(true);
		
		//make database tables. FIRST RUN ONLY
		MakeDatabaseAndData setup = new MakeDatabaseAndData();
		setup.dropTables();
		setup.createTables ( );
		setup.addDataToTicketTable();
		setup.addDataToSysteUserTable();
		setup.closeConn ( );
	}
	
}

