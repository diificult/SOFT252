package gui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.users.UserFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtAddress;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(185, 11, 46, 14);
		contentPane.add(lblNewLabel);

		txtName = new JTextField();
		txtName.setBounds(153, 32, 109, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(153, 85, 109, 20);
		contentPane.add(txtSurname);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(185, 64, 46, 14);
		contentPane.add(lblSurname);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(153, 137, 109, 20);
		contentPane.add(txtAddress);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(185, 116, 46, 14);
		contentPane.add(lblAddress);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Doctor", "Secretary" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(153, 168, 109, 20);
		contentPane.add(comboBox);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(153, 220, 109, 20);
		contentPane.add(txtPassword);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(185, 199, 46, 14);
		contentPane.add(lblPassword);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserFactory.CreateUser(comboBox.getSelectedItem().toString(), txtName.getText(), txtSurname.getText(),
						txtAddress.getText(), txtPassword.getText());
				;
			}
		});
		btnSubmit.setBounds(163, 251, 89, 23);
		contentPane.add(btnSubmit);
	}
}
