package doctor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RequestMedicineScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterName;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestMedicineScreen frame = new RequestMedicineScreen();
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
	public RequestMedicineScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(129, 38, 161, 20);
		contentPane.add(comboBox);
		
		JLabel lblChoose = new JLabel("Choose Medicine");
		lblChoose.setBounds(26, 41, 94, 14);
		contentPane.add(lblChoose);
		
		txtEnterName = new JTextField();
		txtEnterName.setEnabled(false);
		txtEnterName.setText("Enter Name");
		txtEnterName.setBounds(156, 69, 86, 20);
		contentPane.add(txtEnterName);
		txtEnterName.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(156, 111, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(103, 114, 46, 14);
		contentPane.add(lblQuantity);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(153, 154, 89, 23);
		contentPane.add(btnSubmit);
	}

}
