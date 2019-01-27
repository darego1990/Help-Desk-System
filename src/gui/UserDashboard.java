// Craig Hogan X00075734

package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.User;
import net.proteanit.sql.DbUtils;

import database.DBConnection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class UserDashboard extends JFrame {

	private JPanel contentPane;
	private Connection conn = null;
	private ResultSet rset = null;
	private PreparedStatement stmt = null;
	private Statement currvalStatement = null;
	private DBConnection db;
	private JTable table;
	private int userID;
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserDashboard(User user) {
		this.userID = user.getUserID();
		this.userfName = user.getfullName();
				
		setResizable(false);
		
		db = new DBConnection ( );
		conn = db.openDB ( );
		
		this.setIconImage (Toolkit.getDefaultToolkit().getImage("lib/pic.svg.png"));
		setTitle ("User Dashboard");
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
		btnSubmitTicket.setBounds(10, 172, 113, 56);
		contentPane.add(btnSubmitTicket);
		
		JButton btnTicketEditor = new JButton("Ticket Editor");
		btnTicketEditor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewAndEdit view = new ViewAndEdit();
				view.setVisible(true);
			}
		});
		btnTicketEditor.setBounds(133, 172, 113, 56);
		contentPane.add(btnTicketEditor);
		
		JButton btnAccountSettings = new JButton("Account Settings");
		btnAccountSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateAccount update = new UpdateAccount();
				update.setVisible(true);
			}
		});
		btnAccountSettings.setBounds(256, 172, 113, 56);
		contentPane.add(btnAccountSettings);
		
		JPanel panel = new JPanel();
		panel.setBounds(379, 172, 232, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(272, 17, 89, 23);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		panel.add(btnLogout);
		
		JButton btnLogout_1 = new JButton("Logout");
		btnLogout_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login log1 = new Login();
				log1.setVisible(true);
			}
		});
		btnLogout_1.setBounds(10, 27, 65, 18);
		panel.add(btnLogout_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to your account, ");
		lblNewLabel.setBounds(10, 0, 129, 34);
		panel.add(lblNewLabel);
		
		JLabel lblCraig = new JLabel("Craig");
		lblCraig.setBounds(145, 10, 87, 14);
		panel.add(lblCraig);
		lblCraig.setText(userfName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 264, 601, 169);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setBorder(BorderFactory.createTitledBorder("Your Open Tickets"));
		
		table = new JTable();
		JScrollPane scrollpane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_1.add(scrollpane);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnRefreshYourOpen = new JButton("Refresh Your Open Tickets");
		btnRefreshYourOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateTable();
				JOptionPane.showMessageDialog (null, "Your Open Tickets Refreshed Successfully", "Success", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnRefreshYourOpen.setBounds(10, 438, 172, 23);
		contentPane.add(btnRefreshYourOpen);
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
						String sql = "SELECT * FROM ticket WHERE userid = ?";
						stmt=conn.prepareStatement(sql);
						stmt.setInt (1, userID);
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
