package gui.patient;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
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
		setBounds(100, 100, 450, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDr = new JLabel("Doctor");
		lblDr.setBounds(173, 11, 48, 14);
		contentPane.add(lblDr);
		
		DefaultComboBoxModel m = new DefaultComboBoxModel();
		JComboBox comboBox = new JComboBox(m);
		comboBox.setBounds(127, 36, 138, 22);
		contentPane.add(comboBox);
		ArrayList<Doctor> drs = DataManager.GetDoctors();
		for (Doctor d : drs) {
			m.addElement(d.getID() + " Dr " + d.getName() + " " + d.getSurname());
			
		}
		
		JSpinner spDay = new JSpinner();
		spDay.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spDay.setBounds(118, 107, 48, 20);
		contentPane.add(spDay);
		
		JSpinner spMonth = new JSpinner();
		spMonth.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spMonth.setBounds(185, 107, 36, 20);
		contentPane.add(spMonth);
		
		JSpinner spYear = new JSpinner();
		spYear.setModel(new SpinnerNumberModel(2020, 2020, 2021, 1));
		spYear.setBounds(235, 107, 57, 20);
		contentPane.add(spYear);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(173, 82, 48, 14);
		contentPane.add(lblDate);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Here");
				//Write to file in a simple format
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date((int) spYear.getValue(), (int) spMonth.getValue(),(int) spDay.getValue());
				
				String id = m.getSelectedItem().toString().substring(0, 5);
				String DrId = null;

				for (Doctor d : drs) {
					if (d.getID().equals(id)) {
						DrId = d.getID();
						break;
					}
				}
				
				Patient Patient = (data.users.Patient) Main.getAccount();
				String PatientID = Patient.getID();
				
				RequestedAppointment ra = new RequestedAppointment(DrId, PatientID, date);
				DataManager.AddRequestedAppointment(ra);
			}
		});
		btnSubmit.setBounds(160, 164, 89, 23);
		contentPane.add(btnSubmit);
	}
}
