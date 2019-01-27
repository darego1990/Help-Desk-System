// Craig Hogan X00075734

package gui;

import model.User;
import net.proteanit.sql.*;

import java.awt.*;

import database.DBConnection;
import database.TicketOperations;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class AdminDashboard extends JFrame {

	private JPanel contentPane;
	private Connection conn = null;
	private ResultSet rset = null;
	private PreparedStatement stmt = null;
	private Statement currvalStatement = null;
	private DBConnection db;
	private JTable table;
	User user = null;
	private int userID = 0;
	private String userfName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
				    UIManager.getSystemLookAndFeelClassName());
					User user = null;
					AdminDashboard frame = new AdminDashboard(user );
					frame.UpdateTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	
	public AdminDashboard(User user) {
		this.userID=user.getUserID();
		this.userfName = user.getfullName();
		setResizable(false);
		this.user = user;
		db = new DBConnection ( );
		conn = db.openDB ( );
		this.setIconImage (Toolkit.getDefaultToolkit().getImage("lib/pic.svg.png"));
		setTitle ("Admin Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSubmitTicket = new JButton("Submit Ticket");
		btnSubmitTicket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SubmitTicket submit = new SubmitTicket(userID);
				submit.setVisible(true);
			}
		});
		btnSubmitTicket.setBounds(10, 178, 113, 56);
		contentPane.add(btnSubmitTicket);
		
		JButton btnTicketEditor = new JButton("Ticket Editor");
		btnTicketEditor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewAndEdit view = new ViewAndEdit();
				view.setVisible(true);
			}
		});
		btnTicketEditor.setBounds(131, 178, 113, 56);
		contentPane.add(btnTicketEditor);
		
		JButton btnAccountSettings = new JButton("Account Settings");
		btnAccountSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateAccount update = new UpdateAccount();
				update.setVisible(true);
			}
		});
		btnAccountSettings.setBounds(254, 178, 113, 56);
		contentPane.add(btnAccountSettings);
		
		JPanel panel = new JPanel();
		panel.setBounds(381, 178, 230, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to your account, ");
		lblNewLabel.setBounds(10, 0, 129, 34);
		panel.add(lblNewLabel);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		
		JButton button = new JButton("Logout");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login log1 = new Login();
				log1.setVisible(true);
			}
		});
		button.setBounds(10, 27, 65, 18);
		panel.add(button);
		
		JLabel lblCraig = new JLabel("Craig");
		lblCraig.setBounds(146, 10, 84, 14);
		panel.add(lblCraig);
		lblCraig.setText(userfName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 263, 601, 169);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setBorder(BorderFactory.createTitledBorder("Open Tickets"));
		
		table = new JTable();
		JScrollPane scrollpane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_1.add(scrollpane);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnRefreshOpenTickets = new JButton("Refresh Open Tickets");
		btnRefreshOpenTickets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateTable();
				JOptionPane.showMessageDialog (null, "Open Tickets Refreshed", "Success", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnRefreshOpenTickets.setBounds(10, 438, 162, 23);
		contentPane.add(btnRefreshOpenTickets);
		BufferedImage myPicture;
		try {
			
			myPicture = ImageIO.read(new File("lib/Logo.png"));
			JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
			picLabel.setBounds(10, 11, 601, 156);
			getContentPane().add( picLabel );
			
			
			
			
			
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
		}
		
		

	}
	
	// method to populate JTable
	
	public void UpdateTable()
	{
				try 
				{
					String sql = "SELECT * FROM ticket";
					stmt=conn.prepareStatement(sql);
					rset=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rset));
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog (null, "Insert into ticket table failed", "Error", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace ( );
				}
				
	}
}
