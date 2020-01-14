package gui.patient;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.DataManager;
import data.Prescription;
import data.users.Patient;
import gui.Main;

public class PaitientAppointmentHistory extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PaitientAppointmentHistory() {
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
		JList list = new JList(model);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 2;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		contentPane.add(list, gbc_list);
		ArrayList<Prescription> pres = DataManager.GetPrescription();
		Patient pa = (Patient) Main.getAccount();
		ArrayList<Prescription> PatientPrescriptions = new ArrayList<Prescription>();
		int i = 0;
		for (Prescription p : pres) {
			if (p.GetPatientID() == pa.getID()) {
				PatientPrescriptions.add(p);
				model.add(i, "Dr. " + DataManager.GetDoctor(p.GetDoctorID()).getName() + " " + p.GetDate());
				i++;
			}
		}

		// Button that shows the selected
		JButton btnDetails = new JButton("View Details");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnDetails, gbc_btnNewButton);
		btnDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Prescription p = PatientPrescriptions.get(list.getSelectedIndex());
					AppointmentDetails ad = new AppointmentDetails(p);
					ad.setVisible(true);
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, "Please select a prescription from the list");
				}

			}
		});

		JButton btnBack = new JButton("Go Back");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnBack, gbc_btnNewButton_1);
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PatientScreen ps = new PatientScreen((Patient) Main.getAccount());
				ps.setVisible(true);
				dispose();

			}
		});
	}

}
