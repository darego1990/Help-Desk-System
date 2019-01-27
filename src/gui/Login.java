// Craig Hogan X00075734

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import database.*;
import model.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		this.setIconImage (Toolkit.getDefaultToolkit().getImage("lib/pic.svg.png"));
		setTitle ("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(72, 64, 61, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(72, 102, 46, 14);
		contentPane.add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setToolTipText("");
		textFieldUsername.setBounds(143, 61, 132, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				UserOperations userOperations = new UserOperations();
				
				ResultSet rset = userOperations.validateLog(textFieldUsername.getText(), textFieldPassword.getText());
				User user = null;
				try {
					if (rset.next()) {
						 user = new User(rset.getInt("userid"), rset.getString("username"), rset.getString("userpassword"), rset.getString("securityquestion"), rset.getString("securityanswer"),
			                        rset.getInt("adminrights"), rset.getString("email"), rset.getString("fname"), rset.getString("phonenumber"), rset.getString("department"));
						
						
						 if(user.isAdminRights() == 1)
						 {
						    dispose();
						    AdminDashboard admin = new AdminDashboard(user);
						    admin.UpdateTable();
					    	admin.setVisible(true);
						 }
						 else
						 {
							 dispose();
							 UserDashboard user1 = new UserDashboard(user);
							 user1.UpdateTable();
						     user1.setVisible(true);
						 }
						
					}
					else{
						
						JOptionPane.showMessageDialog(null, "Login failed. If you forget your details please make a new account!", "Error", JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		btnLogin.setBounds(84, 140, 73, 23);
		contentPane.add(btnLogin);
		
		JButton btnCreateAccount = new JButton("Create\r\n Account");
		btnCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CreateAccount acc = new CreateAccount();
				acc.setVisible(true);
			}
		});
		btnCreateAccount.setBounds(167, 140, 108, 23);
		contentPane.add(btnCreateAccount);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(160, 11, 46, 29);
		contentPane.add(lblLogin);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(143, 99, 132, 20);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
	}
	
	
}
