package gui.patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PrescriptionScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtMedicine;
	private JTextField txtPatient;
	private JTextField txtDoctor;
	private JTextField txtQuantity;
	private JTextField txtDosage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrescriptionScreen frame = new PrescriptionScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrescriptionScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prescription Name");
		lblNewLabel.setBounds(161, 11, 119, 14);
		contentPane.add(lblNewLabel);
		
		txtMedicine = new JTextField();
		txtMedicine.setEditable(false);
		txtMedicine.setBounds(133, 36, 154, 20);
		contentPane.add(txtMedicine);
		txtMedicine.setColumns(10);
		
		txtPatient = new JTextField();
		txtPatient.setEditable(false);
		txtPatient.setColumns(10);
		txtPatient.setBounds(133, 106, 154, 20);
		contentPane.add(txtPatient);
		
		JLabel lblPatiantname = new JLabel("Patient Name");
		lblPatiantname.setBounds(161, 81, 119, 14);
		contentPane.add(lblPatiantname);
		
		txtDoctor = new JTextField();
		txtDoctor.setEditable(false);
		txtDoctor.setColumns(10);
		txtDoctor.setBounds(133, 162, 154, 20);
		contentPane.add(txtDoctor);
		
		JLabel lblDoctorName = new JLabel("Doctor Name");
		lblDoctorName.setBounds(161, 137, 119, 14);
		contentPane.add(lblDoctorName);
		
		txtQuantity = new JTextField();
		txtQuantity.setEditable(false);
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(133, 226, 154, 20);
		contentPane.add(txtQuantity);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(168, 201, 119, 14);
		contentPane.add(lblQuantity);
		
		txtDosage = new JTextField();
		txtDosage.setEditable(false);
		txtDosage.setColumns(10);
		txtDosage.setBounds(133, 293, 154, 20);
		contentPane.add(txtDosage);
		
		JLabel lblDocage = new JLabel("Dosage");
		lblDocage.setBounds(178, 268, 119, 14);
		contentPane.add(lblDocage);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(161, 337, 89, 23);
		contentPane.add(btnBack);
	}

}
