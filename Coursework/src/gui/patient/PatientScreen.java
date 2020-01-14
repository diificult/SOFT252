package gui.patient;

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

public class PatientScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PatientScreen(Patient p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		//Button to see all of the appointments
		JButton btnHistory = new JButton("View History");
		contentPane.add(btnHistory);
		btnHistory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PaitientAppointmentHistory pah = new PaitientAppointmentHistory();
				pah.setVisible(true);
				dispose();
				
				
			}
		});

		//Button for seeing upcoming appointments
		JButton btnUpcoming = new JButton("View Upcoming Appointments");
		contentPane.add(btnUpcoming);
		btnUpcoming.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientAppointmentList pal = new PatientAppointmentList();
				pal.setVisible(true);
				dispose();
			}
		});
		
		//Button for the screen for the creating of appointments

		JButton btnCreate = new JButton("Create Appointment");
		contentPane.add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAppointment ca = new CreateAppointment();
				ca.setVisible(true);
				dispose();
			}
		});

		
		//Notification of approved appointments
		ArrayList<Appointment> appointmentNotificaiton = p.getNotification();
		if (appointmentNotificaiton != null && !appointmentNotificaiton.isEmpty()) {
			String message = "The following appointments have been approved: \n ";

			//Goes through the list of notifications and adds them to the string
			for (Appointment notifi : appointmentNotificaiton) {
				Doctor d = DataManager.GetDoctor(notifi.GetDoctorID());
				message += notifi.GetDate() + " with " + d.getName() + " " + d.getSurname() + " \n";

			}
			JOptionPane.showMessageDialog(contentPane, message, "Notification", JOptionPane.PLAIN_MESSAGE);
			p.RemoveNotifications();
			DataManager.UpdatePatients();
		}
	}

}
