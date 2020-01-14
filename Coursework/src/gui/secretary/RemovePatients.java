package gui.secretary;

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
import data.users.Patient;

public class RemovePatients extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public RemovePatients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		DefaultListModel model = new DefaultListModel();
		JList lstAccounts = new JList(model);
		GridBagConstraints gbc_lstAccounts = new GridBagConstraints();
		gbc_lstAccounts.gridwidth = 2;
		gbc_lstAccounts.insets = new Insets(0, 0, 5, 5);
		gbc_lstAccounts.fill = GridBagConstraints.BOTH;
		gbc_lstAccounts.gridx = 0;
		gbc_lstAccounts.gridy = 0;
		contentPane.add(lstAccounts, gbc_lstAccounts);
		ArrayList<Patient> ps = DataManager.GetPatients();
		int i = 0;
		for (Patient p : ps) {
			model.add(i, p.getID() + " : " + p.getName() + " " + p.getSurname() + " | " + p.getAddress());
			i++;
		}
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gets selected patient and removes them from the list
				Patient p = ps.get(lstAccounts.getSelectedIndex());
				DataManager.RemovePatient(p);
				model.removeElementAt(lstAccounts.getSelectedIndex());
				ps.remove(p);
			}
		});
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemove.gridx = 0;
		gbc_btnRemove.gridy = 1;
		contentPane.add(btnRemove, gbc_btnRemove);

		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 1;
		contentPane.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SectetaryScreen ss= new SectetaryScreen();
				ss.setVisible(true);
				dispose();
				
				
			}
		});
	}

}
