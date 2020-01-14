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

import com.google.gson.stream.JsonReader;

import data.AccountRequest;
import data.DataManager;
import data.JSon;
import data.users.UserFactory;

public class ApproveAccounts extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ApproveAccounts() {
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
		DataManager.LoadData();
		ArrayList<AccountRequest> ar = DataManager.GetAccountRequests();
		int i = 0;
		for (AccountRequest r : ar) {
			model.add(i, r.GetName() + " " + r.GetSurname() + ", " + r.GetAddress() + ", " + r.GetGender() + ""
					+ r.GetAge());
			i++;
		}

		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountRequest r = ar.get(lstAccounts.getSelectedIndex());
				UserFactory.CreateUser(r.GetName(), r.GetSurname(), r.GetAddress(), r.GetAge(), r.GetGender(),
						r.GetPassword());
				DataManager.RemoveAccountRequest(r);
				model.remove(lstAccounts.getSelectedIndex());
			}
		});
		GridBagConstraints gbc_btnApprove = new GridBagConstraints();
		gbc_btnApprove.insets = new Insets(0, 0, 0, 5);
		gbc_btnApprove.gridx = 0;
		gbc_btnApprove.gridy = 1;
		contentPane.add(btnApprove, gbc_btnApprove);

		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 1;
		contentPane.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SectetaryScreen ss = new SectetaryScreen();
				ss.setVisible(true);
				dispose();
				
			}
		});
	}

}
