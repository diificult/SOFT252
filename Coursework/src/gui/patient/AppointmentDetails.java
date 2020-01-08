package gui.patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class AppointmentDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public AppointmentDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(141, 36, 154, 20);
		contentPane.add(textField);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(188, 11, 66, 14);
		contentPane.add(lblDoctor);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setBounds(197, 67, 57, 14);
		contentPane.add(lblNotes);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(141, 92, 154, 62);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("View Prescription");
		btnNewButton.setBounds(160, 290, 120, 23);
		contentPane.add(btnNewButton);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(141, 190, 154, 62);
		contentPane.add(textPane_1);
		
		JLabel lblWriteFeedback = new JLabel("Write Feedback");
		lblWriteFeedback.setBounds(165, 165, 89, 14);
		contentPane.add(lblWriteFeedback);
		
		JButton btnNewButton_1 = new JButton("Send Feedback");
		btnNewButton_1.setBounds(160, 263, 120, 23);
		contentPane.add(btnNewButton_1);
	}
}
