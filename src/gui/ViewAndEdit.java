// Craig Hogan X00075734

package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.UIManager;

import model.Ticket;

import database.TicketOperations;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class ViewAndEdit extends JFrame {

	private JPanel contentPane;
	private JTextField tfCreated;
	private JTextField tfClosed;
	private JTextField tfName;
	private JTextField tfStatus;
	private JTextField tfQuery;
	private JTextField tfPriority;
	private JTextField tfID;
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
					ViewAndEdit frame = new ViewAndEdit();
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
	public ViewAndEdit() {
		this.setIconImage (Toolkit.getDefaultToolkit().getImage("lib/pic.svg.png"));
		setTitle ("View and Edit Ticket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 196, 72);
		panel.setBorder(BorderFactory.createTitledBorder("Ticket"));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter ticket ID:");
		lblNewLabel.setBounds(10, 11, 107, 23);
		panel.add(lblNewLabel);
		
		tfQuery = new JTextField();
		tfQuery.setBounds(10, 41, 93, 20);
		panel.add(tfQuery);
		tfQuery.setColumns(10);
		
		JButton btnQuery = new JButton("Query");
		btnQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
			String ticketString = tfQuery.getText();
			int ticketID = Integer.parseInt(ticketString);
			
			
			TicketOperations ticketOperations = new TicketOperations();
			
			ResultSet rset = ticketOperations.getTicket(ticketID);
			Ticket ticket = null;
			try {
				if (rset.next()) {
					 ticket = new Ticket(rset.getInt("ticketid"), rset.getString("ticketname"), rset.getString("status"), 
							 rset.getInt("priority"), rset.getString("datecreated"), rset.getString("dateclosed"), rset.getString("conversation"));
					
				}
				else{
					
					JOptionPane.showMessageDialog(null, "get ticket fail!", "Error", JOptionPane.WARNING_MESSAGE);
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			String ticketInt=Integer.toString(ticketID);
			
	          tfID.setText(ticketInt);
	          tfName.setText(ticket.getTicketName());
	          int priorityS = ticket.getPriority();
	          String priority=Integer.toString(priorityS);
	          tfPriority.setText(priority);
	          tfStatus.setText(ticket.getStatus());
	          tfCreated.setText(ticket.getDateCreated());
	          tfClosed.setText(ticket.getDateClosed());
	          textArea.setText(ticket.getConversation());
	      
	          
			}
		});
		btnQuery.setBounds(113, 40, 63, 23);
		panel.add(btnQuery);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 94, 509, 230);
		panel1.setBorder(BorderFactory.createTitledBorder("Ticket Information"));
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 36, 46, 14);
		panel1.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 67, 46, 14);
		panel1.add(lblName);
		
		JLabel lblPriority = new JLabel("Priority:");
		lblPriority.setBounds(10, 98, 46, 14);
		panel1.add(lblPriority);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 134, 46, 14);
		panel1.add(lblStatus);
		
		tfCreated = new JTextField();
		tfCreated.setBounds(85, 168, 142, 20);
		panel1.add(tfCreated);
		tfCreated.setColumns(10);
		
		tfClosed = new JTextField();
		tfClosed.setColumns(10);
		tfClosed.setBounds(85, 199, 142, 20);
		panel1.add(tfClosed);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(85, 64, 142, 20);
		panel1.add(tfName);
		
		JLabel lblTicketConversation = new JLabel("Ticket Conversation");
		lblTicketConversation.setBounds(239, 23, 131, 14);
		panel1.add(lblTicketConversation);
		
		tfStatus = new JTextField();
		tfStatus.setBounds(85, 131, 142, 20);
		panel1.add(tfStatus);
		tfStatus.setColumns(10);
		
		tfPriority = new JTextField();
		tfPriority.setBounds(85, 95, 142, 20);
		panel1.add(tfPriority);
		tfPriority.setColumns(10);
		
		tfID = new JTextField();
		tfID.setBounds(85, 33, 142, 20);
		panel1.add(tfID);
		tfID.setColumns(10);
		
		JLabel lblDateCreated = new JLabel("Date Created:");
		lblDateCreated.setBounds(10, 171, 72, 14);
		panel1.add(lblDateCreated);
		
		JLabel lblDateClosed = new JLabel("Date Closed:");
		lblDateClosed.setBounds(10, 202, 72, 14);
		panel1.add(lblDateClosed);
		
		textArea = new JTextArea();
		textArea.setBounds(237, 45, 262, 174);
		panel1.add(textArea);
		textArea.setWrapStyleWord(true);
		
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String tickettID = tfID.getText();
				int ticketID = Integer.parseInt(tickettID);
				String ticketName = tfName.getText();
				String status = tfStatus.getText();
				String priority = tfPriority.getText();
				String dateCreated = tfCreated.getText();
				String dateClosed = tfClosed.getText();
				String conversation = textArea.getText();
				
				TicketOperations ticket = new TicketOperations();
				ticket.updateTicket(ticketID, ticketName, status, priority, dateCreated, dateClosed, conversation);
				
				dispose();
				
				JOptionPane.showMessageDialog (null, "Ticket Updated", "Success", JOptionPane.WARNING_MESSAGE);
				
			}
		});
		btnUpdate.setBounds(232, 350, 89, 42);
		contentPane.add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(430, 350, 89, 42);
		contentPane.add(btnCancel);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String ticketString = tfQuery.getText();
				int ticketID = Integer.parseInt(ticketString);
				
				TicketOperations ticket = new TicketOperations();
				ticket.deleteTicket(ticketID);
				
				JOptionPane.showMessageDialog (null, "Ticket Deleted", "Success", JOptionPane.WARNING_MESSAGE);
				dispose();
				
			}
		});
		btnNewButton.setBounds(331, 350, 89, 42);
		contentPane.add(btnNewButton);
	}
}
