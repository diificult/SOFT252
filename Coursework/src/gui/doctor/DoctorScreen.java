package gui.doctor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Appointment;
import data.DataManager;
import data.users.Doctor;
import data.users.Patient;

public class DoctorScreen extends JFrame {

	private JPanel contentPane;

	public DoctorScreen(Doctor d) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));

		JButton btnAppointments = new JButton("Appointments");
		contentPane.add(btnAppointments);
		btnAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Appointments a = new Appointments();
				a.setVisible(true);
				dispose();
			}
		});

		JButton btnRequest = new JButton("Request Medicine");
		contentPane.add(btnRequest);
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestMedicine rm = new RequestMedicine();
				rm.setVisible(true);
				dispose();
			}
		});

		//Gets any notifications
		ArrayList<Appointment> appointmentNotificaiton = d.getNotification();
		if (appointmentNotificaiton != null) {
			//Shows that the appointments been approved
			String message = "The following appointments have been approved: \n ";
			//Goes through the list of new appointments adding them to the end of the string
			for (Appointment notifi : appointmentNotificaiton) {
				Patient p = DataManager.GetPatient(notifi.GetPatientID());
				message += notifi.GetDate() + " with " + d.getName() + " " + d.getSurname() + " \n";

			}
			//Shows the messages 
			JOptionPane.showMessageDialog(contentPane, message, "Notification", JOptionPane.PLAIN_MESSAGE);
			//Clears the notification
			d.RemoveNotifications();
			//Updates the doctors without the notification
			DataManager.UpdateDoctor();
		}
	}

}
