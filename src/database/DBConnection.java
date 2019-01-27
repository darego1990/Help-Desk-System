// Craig Hogan X00075734

package database;

import java.sql.*;

import javax.swing.JOptionPane;

import oracle.jdbc.pool.OracleDataSource;

public class DBConnection
{

	private Connection conn = null;

	public Connection openDB ( )
	{
		try
		{
			OracleDataSource ods = new OracleDataSource ( );

			/*************** Tallaght ************/
			
			 

			/************ Home Oracle XE *********/

			ods.setURL("jdbc:oracle:thin:HR/SYSTEM@localhost:1521:orcl");
			ods.setUser("SYSTEM");
			ods.setPassword("db27Oct90");

			conn = ods.getConnection ( );
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog (null, "Unable to load driver " + e);

			System.exit (1);
		}
		return conn;
	}

	public void closeDB ( )
	{
		try
		{
			conn.close ( );

		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog (null, "Could not close connection ");
		}
	}
}
