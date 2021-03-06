package gui.patient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import data.DataManager;
import data.RequestedAppointment;
import data.users.Doctor;
import data.users.Patient;
import gui.Main;

public class CreateAppointment extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CreateAppointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDr = new JLabel("Doctor");
		lblDr.setBounds(193, 11, 48, 14);
		contentPane.add(lblDr);

		DefaultComboBoxModel m = new DefaultComboBoxModel();
		JComboBox comboBox = new JComboBox(m);
		comboBox.setBounds(127, 36, 149, 22);
		contentPane.add(comboBox);
		//Gets the doctors
		ArrayList<Doctor> drs = DataManager.GetDoctors();
		for (Doctor d : drs) {
			
			//Adds doctors to the combo box
			m.addElement(d.getID() + " Dr " + d.getName() + " " + d.getSurname());

		}

		//Spinner for the day limited to 1st-31st
		JSpinner spDay = new JSpinner();
		spDay.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spDay.setBounds(127, 107, 39, 20);
		contentPane.add(spDay);

		//Spinner for the month limited to the 1-12
		JSpinner spMonth = new JSpinner();
		spMonth.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spMonth.setBounds(185, 107, 36, 20);
		contentPane.add(spMonth);

		//Spinner for the year limited to 2020 - 2021
		JSpinner spYear = new JSpinner();
		spYear.setModel(new SpinnerNumberModel(2020, 2020, 2021, 1));
		spYear.setBounds(235, 107, 57, 20);
		contentPane.add(spYear);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(193, 80, 48, 14);
		contentPane.add(lblDate);

		//Spinner for hour limited to 8 - 18 (general open hours)
		JSpinner spHour = new JSpinner();
		spHour.setModel(new SpinnerNumberModel(8, 8, 18, 1));
		spHour.setBounds(150, 165, 48, 20);
		contentPane.add(spHour);

		//Spinner limited to 0-55, going up in steps of 5
		JSpinner spMinute = new JSpinner();
		spMinute.setModel(new SpinnerNumberModel(0, 0, 55, 5));
		spMinute.setBounds(217, 166, 48, 20);
		contentPane.add(spMinute);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				//Stores the date
				Date date = new Date((int) spYear.getValue() - 1900, (int) spMonth.getValue() - 1,
						(int) spDay.getValue(), (int) spHour.getValue(), (int) spMinute.getValue(), 0);
				System.out.println(date);
				String id = m.getSelectedItem().toString().substring(0, 5);
				String DrId = null;

				//Gets the doctors id
				for (Doctor d : drs) {
					if (d.getID().equals(id)) {
						DrId = d.getID();
						break;
					}
				}
				
				//Gets the patient
				Patient Patient = (Patient) Main.getAccount();
				String PatientID = Patient.getID();

				//Adds the new appointment as a request
				RequestedAppointment ra = new RequestedAppointment(DrId, PatientID, date);
				DataManager.AddRequestedAppointment(ra);
				//Goes back to the main menu
				PatientScreen ps = new PatientScreen(Patient);
				ps.setVisible(true);
				dispose();
				
				
			}
		});
		btnSubmit.setBounds(162, 192, 89, 23);
		contentPane.add(btnSubmit);

	}
}
