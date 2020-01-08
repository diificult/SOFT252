package gui.secretary;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Appointment;
import data.AppointmentNotification;
import data.DataManager;
import data.RequestedAppointment;
import data.users.Doctor;
import data.users.Patient;

public class AppointmentApproval extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AppointmentApproval() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Requested Appointments");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Current Future Appointments");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		DefaultListModel model = new DefaultListModel();
		JList lstRequest = new JList(model);
		GridBagConstraints gbc_lstRequest = new GridBagConstraints();
		gbc_lstRequest.gridwidth = 2;
		gbc_lstRequest.insets = new Insets(0, 0, 5, 5);
		gbc_lstRequest.fill = GridBagConstraints.BOTH;
		gbc_lstRequest.gridx = 0;
		gbc_lstRequest.gridy = 1;
		contentPane.add(lstRequest, gbc_lstRequest);
		ArrayList<RequestedAppointment> ra = DataManager.GetRequestedAppointments();
		int i = 0;
		for (RequestedAppointment r : ra) {
			Doctor d = DataManager.GetDoctor(r.GetDoctorID());
			Patient p = DataManager.GetPatient(r.GetPatientID());
			model.add(i, d.getID() + " " + d.getName() + " " + d.getSurname() + " seeing " + p.getID() + " "
					+ p.getName() + " " + p.getSurname() + " at " + r.GetDate());
			i++;
		}

		DefaultListModel futureModel = new DefaultListModel();
		JList lstFuture = new JList(futureModel);
		GridBagConstraints gbc_lstFuture = new GridBagConstraints();
		gbc_lstFuture.gridwidth = 3;
		gbc_lstFuture.insets = new Insets(0, 0, 5, 5);
		gbc_lstFuture.fill = GridBagConstraints.BOTH;
		gbc_lstFuture.gridx = 2;
		gbc_lstFuture.gridy = 1;
		contentPane.add(lstFuture, gbc_lstFuture);
		ArrayList<Appointment> apps = DataManager.GetAppointments();
		i = 0;
		for (Appointment a : apps) {
			Doctor d = DataManager.GetDoctor(a.GetDoctorID());
			Patient p = DataManager.GetPatient(a.GetPatientID());
			futureModel.add(i, d.getID() + " " + d.getName() + " " + d.getSurname() + " seeing " + p.getID() + " "
					+ p.getName() + " " + p.getSurname() + " at " + a.GetDate().toString());
			i++;
		}

		JButton btnApprove = new JButton("Approve with this doctor");
		GridBagConstraints gbc_btnApprove = new GridBagConstraints();
		gbc_btnApprove.insets = new Insets(0, 0, 0, 5);
		gbc_btnApprove.gridx = 0;
		gbc_btnApprove.gridy = 2;
		contentPane.add(btnApprove, gbc_btnApprove);
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestedAppointment r = ra.get(lstRequest.getSelectedIndex());
				Appointment a = new Appointment(r.GetDoctorID(), r.GetPatientID(), r.GetDate());
				Doctor d = DataManager.GetDoctor(r.GetDoctorID());
				Patient p = DataManager.GetPatient(r.GetPatientID());
				DataManager.AddAppointment(a);
				DataManager.RemoveAppointmentRequest(r);
				ra.remove(r);
				futureModel.add(futureModel.getSize(), d.getID() + " " + d.getName() + " " + d.getSurname() + " seeing "
						+ p.getID() + " " + p.getName() + " " + p.getSurname() + " at " + r.GetDate());
				model.remove(lstRequest.getSelectedIndex());
			}
		});

		DefaultComboBoxModel cboDoctorModel = new DefaultComboBoxModel();
		JComboBox cboDoctor = new JComboBox(cboDoctorModel);
		cboDoctor.setToolTipText("Select New Doctor");
		GridBagConstraints gbc_cboDoctor = new GridBagConstraints();
		gbc_cboDoctor.gridwidth = 2;
		gbc_cboDoctor.insets = new Insets(0, 0, 0, 5);
		gbc_cboDoctor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboDoctor.gridx = 1;
		gbc_cboDoctor.gridy = 2;
		contentPane.add(cboDoctor, gbc_cboDoctor);
		ArrayList<Doctor> drs = DataManager.GetDoctors();
		for (Doctor d : drs) {
			cboDoctorModel.addElement(d.getID() + " DR " + d.getName() + " " + d.getSurname());
		}

		JButton btnApproveNew = new JButton("Approve with new selected doctor");
		GridBagConstraints gbc_btnApproveNew = new GridBagConstraints();
		gbc_btnApproveNew.anchor = GridBagConstraints.SOUTH;
		gbc_btnApproveNew.insets = new Insets(0, 0, 0, 5);
		gbc_btnApproveNew.gridx = 3;
		gbc_btnApproveNew.gridy = 2;
		contentPane.add(btnApproveNew, gbc_btnApproveNew);
		btnApproveNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestedAppointment r = ra.get(lstRequest.getSelectedIndex());
				Doctor d = drs.get(cboDoctor.getSelectedIndex());
				Patient p = DataManager.GetPatient(r.GetPatientID());
				Appointment a = new Appointment(d.getID(), r.GetPatientID(), r.GetDate());
				AppointmentNotification notification =  new AppointmentNotification();
				notification.registerObserver(p);
				notification.registerObserver(d);
				notification.addAppointment(a);
				DataManager.AddAppointment(a);
				DataManager.RemoveAppointmentRequest(r);
				ra.remove(r);
				futureModel.add(futureModel.getSize(), d.getID() + " " + d.getName() + " " + d.getSurname() + " seeing "
						+ p.getID() + " " + p.getName() + " " + p.getSurname() + " at " + r.GetDate());
				model.remove(lstRequest.getSelectedIndex());
				
			}
		});

		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 4;
		gbc_btnBack.gridy = 2;
		contentPane.add(btnBack, gbc_btnBack);
	}

}
