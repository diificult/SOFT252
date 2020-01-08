package gui.doctor;

import java.awt.GridLayout;
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
		
		JButton btnRequest = new JButton("Request Medicine");
		contentPane.add(btnRequest);
		ArrayList<Appointment> appointmentNotificaiton = d.getNotification();
		if (appointmentNotificaiton != null) {
			String message = "The following appointments have been approved: \n ";

			for (Appointment notifi : appointmentNotificaiton) {
				Patient p = DataManager.GetPatient(notifi.GetPatientID());
				message += notifi.GetDate() + " with " + d.getName() + " " + d.getSurname() + " \n";

			}
			JOptionPane.showMessageDialog(contentPane, message, "Notification", JOptionPane.PLAIN_MESSAGE);
			d.RemoveNotifications();
			DataManager.UpdateDoctor();
		}
	}

}
