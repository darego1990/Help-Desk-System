// Craig Hogan X00075734

package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import database.UserOperations;

import model.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldUserName;
	private JTextField textFieldEmail;
	private JTextField textFieldDepartment;
	private JTextField textFieldPhone;
	private JTextField textFieldSecQuestion;
	private JTextField textFieldAnswer;
	private JTextField textField_1;
	private int check;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
					UpdateAccount frame = new UpdateAccount();
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
	public UpdateAccount() {
		this.setIconImage (Toolkit.getDefaultToolkit().getImage("lib/pic.svg.png"));
		setTitle ("Update Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseEnterIn = new JLabel("Please enter in your correct Username then enter your information including any changes you wish to make");
		lblPleaseEnterIn.setBounds(10, 26, 536, 14);
		contentPane.add(lblPleaseEnterIn);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(43, 103, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(43, 69, 62, 14);
		contentPane.add(lblusername);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(43, 134, 46, 14);
		contentPane.add(lblemail);
		
		JLabel lbldepartment = new JLabel("Department");
		lbldepartment.setBounds(43, 169, 73, 14);
		contentPane.add(lbldepartment);
		
		JLabel lblphoneNumber = new JLabel("Phone Number");
		lblphoneNumber.setBounds(267, 169, 89, 14);
		contentPane.add(lblphoneNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(267, 69, 46, 14);
		contentPane.add(lblPassword);
		
		JLabel lblSecQuestion = new JLabel("Security Question");
		lblSecQuestion.setBounds(267, 103, 89, 14);
		contentPane.add(lblSecQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(267, 134, 46, 14);
		contentPane.add(lblAnswer);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(115, 100, 129, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(115, 66, 129, 20);
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
		textFieldPhone.setBounds(361, 166, 129, 20);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
					
					String userName = textFieldUserName.getText();
					String userPassword = textField_1.getText();
					String securityQuestion = textFieldSecQuestion.getText();
					String securityAnswer = textFieldAnswer.getText();
					String email = textFieldEmail.getText();
					String fName = textFieldName.getText();
					String phoneNumber = textFieldPhone.getText();
					String department = textFieldDepartment.getText();
					
					UserOperations userOperations = new UserOperations();
					userOperations.updateUser(userName, userPassword, securityQuestion, securityAnswer, email, fName, phoneNumber, department);
					
					JOptionPane.showMessageDialog (null, "Account Updated Successfully", "Success", JOptionPane.WARNING_MESSAGE);
					dispose();
					
			}
		});
		btnUpdate.setBounds(125, 231, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldName.setText(null);
				textFieldUserName.setText(null);
				textFieldEmail.setText(null);
				textFieldDepartment.setText(null);
				textFieldPhone.setText(null);
				textField_1.setText(null);
				textFieldSecQuestion.setText(null);
				textFieldAnswer.setText(null);
			}
		});
		btnClear.setBounds(224, 231, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(323, 231, 89, 23);
		contentPane.add(btnCancel);
		
		textFieldSecQuestion = new JTextField();
		textFieldSecQuestion.setBounds(361, 100, 129, 20);
		contentPane.add(textFieldSecQuestion);
		textFieldSecQuestion.setColumns(10);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setBounds(361, 131, 129, 20);
		contentPane.add(textFieldAnswer);
		textFieldAnswer.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(361, 66, 129, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
