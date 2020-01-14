package gui.patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class AppointmentDetails extends JFrame {

	private JPanel contentPane;
	private JTextField txtDoctor;
	private JTextField txtNotes;
	private JTextField txtMedicine;



	/**
	 * Create the frame.
	 */
	public AppointmentDetails()Appointment a {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Doctor");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtDoctor = new JTextField();
		txtDoctor.setEditable(false);
		GridBagConstraints gbc_txtDoctor = new GridBagConstraints();
		gbc_txtDoctor.insets = new Insets(0, 0, 5, 0);
		gbc_txtDoctor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDoctor.gridx = 0;
		gbc_txtDoctor.gridy = 1;
		contentPane.add(txtDoctor, gbc_txtDoctor);
		txtDoctor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Notes");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtNotes = new JTextField();
		txtNotes.setEditable(false);
		GridBagConstraints gbc_txtNotes = new GridBagConstraints();
		gbc_txtNotes.insets = new Insets(0, 0, 5, 0);
		gbc_txtNotes.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNotes.gridx = 0;
		gbc_txtNotes.gridy = 3;
		contentPane.add(txtNotes, gbc_txtNotes);
		txtNotes.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Medicine");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtMedicine = new JTextField();
		txtMedicine.setEditable(false);
		GridBagConstraints gbc_txtMedicine = new GridBagConstraints();
		gbc_txtMedicine.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMedicine.gridx = 0;
		gbc_txtMedicine.gridy = 5;
		contentPane.add(txtMedicine, gbc_txtMedicine);
		txtMedicine.setColumns(10);
	}

}
