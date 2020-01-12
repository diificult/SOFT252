package gui.doctor;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Appointment;
import data.DataManager;
import data.users.Doctor;
import data.users.Patient;
import gui.Main;

public class Appointments extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Appointments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		DefaultListModel model = new DefaultListModel();
		JList lstAppointments = new JList(model);
		GridBagConstraints gbc_lstAppointments = new GridBagConstraints();
		gbc_lstAppointments.gridwidth = 2;
		gbc_lstAppointments.insets = new Insets(0, 0, 5, 5);
		gbc_lstAppointments.fill = GridBagConstraints.BOTH;
		gbc_lstAppointments.gridx = 0;
		gbc_lstAppointments.gridy = 0;
		contentPane.add(lstAppointments, gbc_lstAppointments);
		ArrayList<Appointment> apps = DataManager.GetAppointments();
		Doctor account = (Doctor)Main.getAccount();
		int i = 0;
		for (Appointment a : apps) {
			
			if (a.GetDoctorID().equals(account.getID())) {
				Patient p = DataManager.GetPatient(a.GetPatientID());
				model.add(i, a.GetDate() + " with " + p.getName() + " " + p.getSurname());
				i++;
			}
		}
		
		JButton btnStart = new JButton("Start Appointment");
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 0, 5);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 1;
		contentPane.add(btnStart, gbc_btnStart);
		
		JButton btnNewButton_1 = new JButton("Back");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);	
	}

}
