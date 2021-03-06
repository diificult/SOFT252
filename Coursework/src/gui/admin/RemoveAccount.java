package gui.admin;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.DataManager;
import data.users.Doctor;
import data.users.Secretary;

public class RemoveAccount extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public RemoveAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		//Creates a model for the list of accounts
		DefaultListModel model = new DefaultListModel();
		//Makes the list of accounts
		JList listAccounts = new JList(model);
		GridBagConstraints gbc_listAccounts = new GridBagConstraints();
		gbc_listAccounts.gridwidth = 2;
		gbc_listAccounts.insets = new Insets(0, 0, 5, 0);
		gbc_listAccounts.fill = GridBagConstraints.BOTH;
		gbc_listAccounts.gridx = 0;
		gbc_listAccounts.gridy = 0;
		contentPane.add(listAccounts, gbc_listAccounts);
		//Gets all of the removable accounts
		ArrayList<Doctor> drs = DataManager.GetDoctors();
		ArrayList<Secretary> secs = DataManager.GetSecretarys();
		int i = 0;
		//Makes sure that there are doctors
		if (drs != null) {
			//Gets all of the doctors
			for (Doctor d : drs) {
				//Adds the doctors to the list
				model.add(i, d.getID() + " : " + d.getName() + " " + d.getSurname() + ", " + d.getAddress());
				i++;
			}
		}
		if (secs != null) {
			for (Secretary s : secs) {

				model.add(i, s.getID() + " : " + s.getName() + " " + s.getSurname() + ", " + s.getAddress());
				i++;
			}
		}

		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 1;
		contentPane.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminScreen as = new AdminScreen();
				as.setVisible(true);
				dispose();
				
			}
		});

		JButton btnRemove = new JButton("Remove");
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.gridx = 1;
		gbc_btnRemove.gridy = 1;
		contentPane.add(btnRemove, gbc_btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gets the ID of the selected to be remove accounts
				String id = model.get(listAccounts.getSelectedIndex()).toString().substring(0, 5);
				//Goes through each of the doctors
				for (Doctor d : drs) {
					//Checks to see if the ids match
					if (d.getID().equals(id)) {
						//Remove the selected item
						model.remove(listAccounts.getSelectedIndex());
						//Removes the doctor
						DataManager.RemoveDoctor(d);
						//Breaks from the check
						break;
					}
				}
				for (Secretary s : secs) {
					if (s.getID().equals(id)) {
						model.remove(listAccounts.getSelectedIndex());
						DataManager.RemoveSecretary(s);
						break;
					}
				}
			}
		});
	}

}
