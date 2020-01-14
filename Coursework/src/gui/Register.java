package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.AccountRequest;
import data.DataManager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtAddress;
	private JTextField txtPassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(95, 36, 215, 31);
		contentPane.add(txtName);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(183, 23, 33, 14);
		contentPane.add(lblName);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(183, 78, 62, 14);
		contentPane.add(lblSurname);

		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(95, 90, 215, 31);
		contentPane.add(txtSurname);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(95, 149, 215, 31);
		contentPane.add(txtAddress);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(183, 132, 62, 14);
		contentPane.add(lblAddress);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(190, 191, 26, 14);
		contentPane.add(lblAge);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(183, 261, 42, 14);
		contentPane.add(lblGender);

		JRadioButton rbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rbtnFemale);
		rbtnFemale.setBounds(107, 282, 109, 23);
		contentPane.add(rbtnFemale);

		JRadioButton rbtnMale = new JRadioButton("Male");
		buttonGroup.add(rbtnMale);
		rbtnMale.setBounds(218, 282, 109, 23);
		contentPane.add(rbtnMale);

		txtPassword = new JTextField();
		txtPassword.setToolTipText("Enter Password");
		txtPassword.setColumns(10);
		txtPassword.setBounds(95, 331, 215, 31);
		contentPane.add(txtPassword);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(183, 312, 62, 14);
		contentPane.add(lblPassword);

		JSpinner spAge = new JSpinner();
		spAge.setModel(new SpinnerNumberModel(1, 0, 115, 1));
		spAge.setBounds(183, 216, 42, 34);
		contentPane.add(spAge);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();
				String Surname = txtSurname.getText();
				String address = txtAddress.getText();
				int age = (int) spAge.getValue();
				char gender = 'n';
				if (rbtnFemale.isEnabled()) {
					gender = 'f';
				} else {
					gender = 'm';
				}
				String password = txtPassword.getText();
				AccountRequest newAccount = new AccountRequest(name, Surname, address, age, gender, password);
				DataManager.AddAccountRequest(newAccount);
				JOptionPane.showMessageDialog(contentPane,
						"You account request has been placed, please wait to hear back from a secretary");
			}
		});
		btnSubmit.setBounds(156, 374, 89, 23);
		contentPane.add(btnSubmit);

	}
}
