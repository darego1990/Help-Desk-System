// Craig Hogan X00075734

package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	private String adminPassword = "admin1";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
					AdminPassword frame = new AdminPassword();
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
	public AdminPassword() {
		this.setIconImage (Toolkit.getDefaultToolkit().getImage("lib/pic.svg.png"));
		setTitle ("Admin Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseEnterIn = new JLabel("Please enter in the admin password");
		lblPleaseEnterIn.setBounds(86, 11, 177, 14);
		contentPane.add(lblPleaseEnterIn);
		
		JLabel lblAdminPassword = new JLabel("Admin password");
		lblAdminPassword.setBounds(40, 68, 99, 14);
		contentPane.add(lblAdminPassword);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(97, 125, 65, 23);
		contentPane.add(btnEnter);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(172, 125, 65, 23);
		contentPane.add(btnCancel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 65, 125, 20);
		contentPane.add(passwordField);
	}

}
