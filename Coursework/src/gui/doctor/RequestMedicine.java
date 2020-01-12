package gui.doctor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.DataManager;
import data.MedicineRequest;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RequestMedicine extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestMedicine frame = new RequestMedicine();
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
	public RequestMedicine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 0;
		gbc_txtName.gridy = 1;
		contentPane.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JSpinner spQty = new JSpinner();
		spQty.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_spQty = new GridBagConstraints();
		gbc_spQty.insets = new Insets(0, 0, 5, 0);
		gbc_spQty.gridx = 0;
		gbc_spQty.gridy = 3;
		contentPane.add(spQty, gbc_spQty);
		
		JButton btnRequest = new JButton("Request");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtName.getText().isEmpty()) {
					MedicineRequest newRquest = new MedicineRequest(txtName.getText(), (int)spQty.getValue());
					DataManager.AddMedicineRequest(newRquest);
				}
			}
		});
		GridBagConstraints gbc_btnRequest = new GridBagConstraints();
		gbc_btnRequest.gridx = 0;
		gbc_btnRequest.gridy = 4;
		contentPane.add(btnRequest, gbc_btnRequest);
	}

}
