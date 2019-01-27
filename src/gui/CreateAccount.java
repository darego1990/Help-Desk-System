// Craig Hogan X00075734

package gui;
import database.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

import database.UserOperations;

import model.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldUserName;
	private JTextField textFieldEmail;
	private JTextField textFieldDepartment;
	private JTextField textFieldPhone;
	private JTextField textFieldSecQuestion;
	private JTextField textFieldAnswer;
	private JTextField passwordField_1;
	private JTextField textFieldAccount;
	private int check = 1; // check if all fields are filled in 

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		
		this.setIconImage (Toolkit.getDefaultToolkit().getImage("lib/pic.svg.png"));
		setTitle ("Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseEnterIn = new JLabel("Please enter in your information to create a new account");
		lblPleaseEnterIn.setBounds(115, 11, 285, 14);
		contentPane.add(lblPleaseEnterIn);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(43, 69, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(267, 69, 62, 14);
		contentPane.add(lblusername);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(43, 134, 46, 14);
		contentPane.add(lblemail);
		
		JLabel lbldepartment = new JLabel("Department");
		lbldepartment.setBounds(43, 169, 73, 14);
		contentPane.add(lbldepartment);
		
		JLabel lblphoneNumber = new JLabel("Phone Number");
		lblphoneNumber.setBounds(43, 194, 89, 14);
		contentPane.add(lblphoneNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(43, 103, 46, 14);
		contentPane.add(lblPassword);
		
		JLabel lblSecQuestion = new JLabel("Security Question");
		lblSecQuestion.setBounds(267, 103, 89, 14);
		contentPane.add(lblSecQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(267, 134, 46, 14);
		contentPane.add(lblAnswer);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(115, 66, 129, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(361, 66, 129, 20);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(115, 131, 129, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldDepartment = new JTextField();
		textFieldDepartment.setBounds(115, 162, 129, 20);
		contentPane.add(textFieldDepartment);
		textFieldDepartment.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(115, 191, 129, 20);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				User user1 = null;
				
				//set check variable to see if all fields are filled
				if(textFieldName.equals(null))
				{
					check = 0;
				}
				else if(textFieldUserName.equals(null))
				{
					check = 0;
				}
				else if(textFieldEmail.equals(null))
				{
					check = 0;
				}
				else if(textFieldDepartment.equals(null))
				{
					check = 0;
				}
				else if(textFieldPhone.equals(null))
				{
					check = 0;
				}
				else if(passwordField_1.equals(null))
				{
					check = 0;
				}
				else if(passwordField_1.equals(null))
				{
					check = 0;
				}
				else if(textFieldSecQuestion.equals(null))
				{
					check = 0;
				}
				else if(textFieldAnswer.equals(null))
				{
					check = 0;
				}
				
				// opens admin or user dashboard
				String account = textFieldAccount.getText();
				if(account.equals("admin"))
				{
					//checks to see if all fields are filled in before opening dashboard
					if(check == 1)
					{
						String userName = textFieldName.getText();
						String userPassword = passwordField_1.getText();
						String securityQuestion = textFieldSecQuestion.getText();
						String securityAnswer = textFieldAnswer.getText();
						String email = textFieldEmail.getText();
						String fName = textFieldName.getText();
						String phoneNumber = textFieldPhone.getText();
						String department = textFieldDepartment.getText();
						
						UserOperations userOperations = new UserOperations();
						
						userOperations.createAccount(userName,userPassword, securityQuestion, securityAnswer, email, fName, phoneNumber, department);
						ResultSet rset = userOperations.validateAcccount(userName, userPassword);
						User user = null;
						
						try {
							
							if (rset.next()) {
						
								 user = new User(rset.getInt("userid"), rset.getString("username"), rset.getString("userpassword"), rset.getString("securityquestion"), rset.getString("securityanswer"),
					                        rset.getInt("adminrights"), rset.getString("email"), rset.getString("fname"), rset.getString("phonenumber"), rset.getString("department"));
							}
							
							else{
								
								JOptionPane.showMessageDialog(null, "Login to admin fail!", "Error", JOptionPane.WARNING_MESSAGE);
							}
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
						dispose();
						AdminDashboard admin = new AdminDashboard(user);
						admin.UpdateTable();
						admin.setVisible(true);
					}
					else if (check == 0)
					{
						JOptionPane.showMessageDialog (null, "Please fill in all data fields");
					}
				}
				else if (account.equals("normal"))
				{
					//checks to see if all fields are filled in before opening dashboard
					if(check == 1)
					{
						String userName = textFieldName.getText();
						String userPassword = passwordField_1.getText();
						String securityQuestion = textFieldSecQuestion.getText();
						String securityAnswer = textFieldAnswer.getText();
						String email = textFieldEmail.getText();
						String fName = textFieldName.getText();
						String phoneNumber = textFieldPhone.getText();
						String department = textFieldDepartment.getText();
						
						UserOperations userOperations = new UserOperations();
						
						userOperations.createUserAccount(userName,userPassword, securityQuestion, securityAnswer, email, fName, phoneNumber, department);
						ResultSet rset = userOperations.validateAcccount(userName, userPassword);
						User user = null;
						
							try {
							
							if (rset.next()) {
						
								 user = new User(rset.getInt("userid"), rset.getString("username"), rset.getString("userpassword"), rset.getString("securityquestion"), rset.getString("securityanswer"),
					                        rset.getInt("adminrights"), rset.getString("email"), rset.getString("fname"), rset.getString("phonenumber"), rset.getString("department"));
							}
							
							else{
								
								JOptionPane.showMessageDialog(null, "Login to user fail!", "Error", JOptionPane.WARNING_MESSAGE);
							}
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
						
						dispose();
						UserDashboard userd = new UserDashboard(user);
						userd.UpdateTable();
						userd.setVisible(true);
					}
					else if (check == 0)
					{
						JOptionPane.showMessageDialog (null, "Please fill in all data fields");
					}
				}
			}
		});
		btnEnter.setBounds(125, 262, 89, 23);
		contentPane.add(btnEnter);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			
			
			public void mouseClicked(MouseEvent arg0) {
				textFieldName.setText(null);
				textFieldUserName.setText(null);
				textFieldEmail.setText(null);
				textFieldDepartment.setText(null);
				textFieldPhone.setText(null);
				passwordField_1.setText(null);
				passwordField_1.setText(null);
				textFieldSecQuestion.setText(null);
				textFieldAnswer.setText(null);
				textFieldAccount.setText(null);

			}
		});
		btnClear.setBounds(224, 262, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login log1 = new Login();
				log1.setVisible(true);
			}
		});
		btnCancel.setBounds(323, 262, 89, 23);
		contentPane.add(btnCancel);
		
		textFieldSecQuestion = new JTextField();
		textFieldSecQuestion.setBounds(361, 100, 129, 20);
		contentPane.add(textFieldSecQuestion);
		textFieldSecQuestion.setColumns(10);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setBounds(361, 131, 129, 20);
		contentPane.add(textFieldAnswer);
		textFieldAnswer.setColumns(10);
		
		JLabel lblAccountType = new JLabel("Account type");
		lblAccountType.setBounds(267, 169, 89, 14);
		contentPane.add(lblAccountType);
		
		passwordField_1 = new JTextField();
		passwordField_1.setBounds(115, 100, 129, 20);
		contentPane.add(passwordField_1);
		passwordField_1.setColumns(10);
		
		textFieldAccount = new JTextField();
		textFieldAccount.setBounds(361, 166, 129, 20);
		contentPane.add(textFieldAccount);
		textFieldAccount.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\"normal\" or \"admin\"");
		lblNewLabel.setBounds(361, 194, 129, 14);
		contentPane.add(lblNewLabel);

	}
}
