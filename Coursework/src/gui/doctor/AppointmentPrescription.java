package gui.doctor;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import data.Appointment;
import data.DataManager;
import data.Medicine;
import data.Prescription;
import data.users.Doctor;
import data.users.Patient;
import gui.Main;

public class AppointmentPrescription extends JFrame {

	private JPanel contentPane;
	private JTextField txtPaitient;
	private JTextField txtNotes;
	private JTextField txtDosage;
	private final JCheckBox cboxMax = new JCheckBox("Give max? (If limited qty)");

	/**
	 * Create the frame.
	 */
	public AppointmentPrescription(Patient p, Appointment a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Paitient");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		txtPaitient = new JTextField();
		txtPaitient.setEditable(false);
		GridBagConstraints gbc_txtPaitient = new GridBagConstraints();
		gbc_txtPaitient.gridwidth = 2;
		gbc_txtPaitient.insets = new Insets(0, 0, 5, 0);
		gbc_txtPaitient.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPaitient.gridx = 0;
		gbc_txtPaitient.gridy = 1;
		contentPane.add(txtPaitient, gbc_txtPaitient);
		txtPaitient.setColumns(10);
		txtPaitient.setText(p.getName() + " " + p.getSurname() + " ," + p.getAddress() + " Age:" + p.getAge() + " Gender:" + p.getGender());

		JLabel lblNewLabel_1 = new JLabel("Add Notes");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtNotes = new JTextField();
		GridBagConstraints gbc_txtNotes = new GridBagConstraints();
		gbc_txtNotes.gridwidth = 2;
		gbc_txtNotes.insets = new Insets(0, 0, 5, 0);
		gbc_txtNotes.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNotes.gridx = 0;
		gbc_txtNotes.gridy = 3;
		contentPane.add(txtNotes, gbc_txtNotes);
		txtNotes.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Add Medicine?");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		
		//Makes the model for the combo box
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		JComboBox cboMedicine = new JComboBox(model);
		GridBagConstraints gbc_cboMedicine = new GridBagConstraints();
		gbc_cboMedicine.gridwidth = 2;
		gbc_cboMedicine.insets = new Insets(0, 0, 5, 0);
		gbc_cboMedicine.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboMedicine.gridx = 0;
		gbc_cboMedicine.gridy = 5;
		contentPane.add(cboMedicine, gbc_cboMedicine);
		//Gets all the medicine
		ArrayList<Medicine> Meds = DataManager.GetMedicines();

		for (Medicine m : Meds) {
			//Adds all the medicine
			model.addElement(m.GetName());
		}
		//Set the selected medicine as blank
		cboMedicine.setSelectedIndex(-1);

		JLabel lblNewLabel_3 = new JLabel("Dosage");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 6;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		txtDosage = new JTextField();
		txtDosage.setEnabled(false);
		GridBagConstraints gbc_txtDosage = new GridBagConstraints();
		gbc_txtDosage.gridwidth = 2;
		gbc_txtDosage.insets = new Insets(0, 0, 5, 0);
		gbc_txtDosage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDosage.gridx = 0;
		gbc_txtDosage.gridy = 7;
		contentPane.add(txtDosage, gbc_txtDosage);
		txtDosage.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Quantity");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 2;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 8;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JSpinner spQty = new JSpinner();
		spQty.setEnabled(false);
		spQty.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_spQty = new GridBagConstraints();
		gbc_spQty.insets = new Insets(0, 0, 5, 5);
		gbc_spQty.gridx = 0;
		gbc_spQty.gridy = 9;
		contentPane.add(spQty, gbc_spQty);
		GridBagConstraints gbc_cboxMax = new GridBagConstraints();
		gbc_cboxMax.insets = new Insets(0, 0, 5, 0);
		gbc_cboxMax.gridx = 1;
		gbc_cboxMax.gridy = 9;
		cboxMax.setEnabled(false);
		cboxMax.setFont(new Font("Tahoma", Font.PLAIN, 23));
		contentPane.add(cboxMax, gbc_cboxMax);
		//Enables and disables the medicine data depending if there is a medicine selected
		cboMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cboMedicine.getSelectedIndex() == -1) {
					txtDosage.setEnabled(false);
					spQty.setEnabled(false);
					cboxMax.setEnabled(false);
				} else {
					txtDosage.setEnabled(true);
					spQty.setEnabled(true);
					cboxMax.setEnabled(true);
				}
			}
		});

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Gets the note and the doctor details
				String notes = txtNotes.getText();
				String drName = ((Doctor) Main.getAccount()).getName();
				//Gets the quantity of the medicine
				int qty = (int) spQty.getValue();
				//Checks to see if there is medicine selected
				if (cboMedicine.getSelectedIndex() != -1) {
					//Makes a  new medicine
					Medicine m = Meds.get(cboMedicine.getSelectedIndex());
					//Checks to see if the user wants to get the maximum number of qty regardless of stock
					if (cboxMax.isSelected()) {
						//Removes the stock saying getting the max
						qty = m.RemoveStock((int) spQty.getValue(), true);
						//Tells the user how much stock was retrieved
						JOptionPane.showMessageDialog(contentPane, "The quantity retrieved was: " + qty);
					} else {
						//Attempts to remove the stock
						boolean getQty = m.RemoveStock(qty);
						if (getQty) {

							//If they couldnt get the stock
						} else {
							//Checks to see if they want to get the maximum number of stock anyways
							int override = JOptionPane.showConfirmDialog(null, "Too little Qty",
									"Would you like to override the medicine ", JOptionPane.YES_NO_OPTION);
							if (override == 1) {
								//If they do then remove the stocks
								qty = m.RemoveStock((int) spQty.getValue(), true);
							} else {
								//If not clear the medicine
								m = null;
								qty = 0;
							}
						}
					}
					//if there is medicine
					if (m != null) {
						
						//Adds the prescription with the medicine details
						Medicine NewMedicine = new Medicine(m.GetName());
						Prescription pre = new Prescription(((Doctor) Main.getAccount()).getID(), p.getID(),
								txtNotes.getText(), NewMedicine, qty, txtDosage.getText(), a.GetDate());
						DataManager.AddPrescription(pre);
						//Remove the appointment as its been done
						DataManager.RemoveAppointment(a);
					} else {
						//Otherwise adds the prescription with no medicine data
						Prescription pre = new Prescription(((Doctor) Main.getAccount()).getID(), p.getID(),
								txtNotes.getText(), a.GetDate());
						DataManager.AddPrescription(pre);
						DataManager.RemoveAppointment(a);
					}

				} else {
					Prescription pre = new Prescription(((Doctor) Main.getAccount()).getID(), p.getID(),
							txtNotes.getText(), a.GetDate());
					DataManager.AddPrescription(pre);
					DataManager.RemoveAppointment(a);
				}
				//Returns to the appointment menu
				Appointments a = new Appointments();
				a.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridwidth = 2;
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 10;
		contentPane.add(btnSubmit, gbc_btnSubmit);

	}

}
