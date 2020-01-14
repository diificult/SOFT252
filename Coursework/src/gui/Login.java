package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.DataManager;
import data.users.Admin;
import data.users.Doctor;
import data.users.Patient;
import data.users.Secretary;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtPassword;
	private JLabel lblPassword;
	private JButton btnLogin;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtID = new JTextField();
		txtID.setBounds(102, 76, 215, 31);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblName = new JLabel("ID");
		lblName.setBounds(202, 58, 11, 14);
		contentPane.add(lblName);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(102, 135, 215, 31);
		contentPane.add(txtPassword);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(186, 118, 46, 14);
		contentPane.add(lblPassword);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gets which role is being logged into
				char role = Character.toUpperCase(txtID.getText().charAt(0));
				//Switch case for this
				switch (role) {
				case 'P':
					//Gets all of the patients
					ArrayList<Patient> patients = DataManager.GetPatients();
					//Goes through them all
					for (Patient p : patients) {
						//if the ID and password matches then it will allowed to be logged in
						if (txtID.getText().equalsIgnoreCase(p.getID())
								&& txtPassword.getText().equalsIgnoreCase(p.getPassword())) {
							Main.OpenPatient(p);
							dispose();

						}
					}
					//Breaks from case
					break;
				case 'D':
					ArrayList<Doctor> drs = DataManager.GetDoctors();
					for (Doctor d : drs) {
						if (txtID.getText().equalsIgnoreCase(d.getID())
								&& txtPassword.getText().equalsIgnoreCase(d.getPassword())) {
							Main.OpenDoctor(d);
							dispose();
						}
					}
					break;
				case 'S':
					ArrayList<Secretary> secs = DataManager.GetSecretarys();
					for (Secretary s : secs) {
						if (txtID.getText().equalsIgnoreCase(s.getID())
								&& txtPassword.getText().equalsIgnoreCase(s.getPassword())) {
							Main.OpenSecretary(s);
							dispose();
						}
					}
					break;
				case 'A':

					ArrayList<Admin> admins = DataManager.GetAdmins();
					for (Admin a : admins) {
						if (txtID.getText().equalsIgnoreCase(a.getID())
								&& txtPassword.getText().equalsIgnoreCase(a.getPassword())) {
							Main.OpenAdmin(a);
							dispose();
						}
					}
					break;
				default:
					//If it doesnt match any type then dont do anything
					break;
				}
			}
		});
		btnLogin.setBounds(167, 177, 89, 23);
		contentPane.add(btnLogin);
	}
}
