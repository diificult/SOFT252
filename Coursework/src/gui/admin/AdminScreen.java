package gui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class AdminScreen extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public AdminScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 50, 3));

		
		//Button to load up the screen to remove accounts
		JButton btnRemove = new JButton("Remove Account");
		contentPane.add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gets the class object
				RemoveAccount rc = new RemoveAccount();
				//Makes the JFrame visible
				rc.setVisible(true);
				//Dispose of this screen to get rid of it
				dispose();
			}
		});
		//Button to load up the screen to create accounts
		JButton btnCreate = new JButton("Create Account");
		contentPane.add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount ca = new CreateAccount();
				ca.setVisible(true);
				contentPane.setVisible(false);
			}
		});

		//Button to load up the screen where admins can give feedback to the doctors
		JButton btnFeedback = new JButton("Feedback (Unimplemented)");
		contentPane.add(btnFeedback);
		btnFeedback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RatingManager rm = new RatingManager();
				rm.setVisible(true);
				dispose();
				
			}
		});

	}

}
