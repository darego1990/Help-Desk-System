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
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SecurityQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
					SecurityQuestion frame = new SecurityQuestion();
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
	public SecurityQuestion() {
		this.setIconImage (Toolkit.getDefaultToolkit().getImage("lib/pic.svg.png"));
		setTitle ("Security Question");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseConfirmYour = new JLabel("Please confirm your security question");
		lblPleaseConfirmYour.setBounds(74, 11, 203, 14);
		contentPane.add(lblPleaseConfirmYour);
		
		JLabel lblSecQuestion = new JLabel("Security Question");
		lblSecQuestion.setBounds(40, 59, 106, 14);
		contentPane.add(lblSecQuestion);
		
		String secQuestion = "";
		JLabel lblNewLabel_1 = new JLabel(secQuestion );
		lblNewLabel_1.setBounds(142, 59, 85, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(85, 87, 46, 14);
		contentPane.add(lblAnswer);
		
		textField = new JTextField();
		textField.setBounds(141, 84, 119, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(96, 138, 65, 23);
		contentPane.add(btnEnter);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(173, 138, 65, 23);
		contentPane.add(btnCancel);
	}

}
