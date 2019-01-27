// Craig Hogan X00075734

package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

import database.TicketOperations;

import model.User;

public class SubmitTicket extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int userID;
	private JTextArea textArea;
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
	public SubmitTicket(final int userID) {
		this.userID = userID;
		this.setIconImage (Toolkit.getDefaultToolkit().getImage("lib/pic.svg.png"));
		setTitle ("Submit ticket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 375, 369);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Enter Ticket Information"));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 21, 46, 14);
		panel.add(lblName);
		
		JLabel lblTicketDescription = new JLabel("Ticket Description:");
		lblTicketDescription.setBounds(10, 46, 88, 14);
		panel.add(lblTicketDescription);
		
		textField = new JTextField();
		textField.setBounds(108, 18, 233, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(108, 46, 257, 312);
		panel.add(textArea);
		textArea.setWrapStyleWord(true);
		
	
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String ticketName = textField.getText();
				String conversation = textArea.getText();
						
				TicketOperations ticket = new TicketOperations();
				ticket.createTicket(ticketName, conversation, userID);
				dispose();
				
				JOptionPane.showMessageDialog (null, "Your ticket has been submitted", "Success", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnEnter.setBounds(197, 391, 89, 39);
		contentPane.add(btnEnter);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(296, 391, 89, 39);
		contentPane.add(btnCancel);
	}

}
