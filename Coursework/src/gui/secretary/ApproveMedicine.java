package gui.secretary;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import data.DataManager;
import data.Medicine;
import data.MedicineRequest;

public class ApproveMedicine extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApproveMedicine frame = new ApproveMedicine();
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
	public ApproveMedicine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Medicines");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		DefaultListModel model = new DefaultListModel();
		JList lstMedicines = new JList(model);
		GridBagConstraints gbc_lstMedicines = new GridBagConstraints();
		gbc_lstMedicines.insets = new Insets(0, 0, 5, 0);
		gbc_lstMedicines.fill = GridBagConstraints.BOTH;
		gbc_lstMedicines.gridx = 0;
		gbc_lstMedicines.gridy = 1;
		contentPane.add(lstMedicines, gbc_lstMedicines);
		ArrayList<MedicineRequest> MedicineRequests = DataManager.GetMedicineRequests();
		int i = 0;
		for (MedicineRequest r : MedicineRequests) {
			model.add(i, r.getName() + ", QTY: " + r.getRQty());
			i++;
		}

		JCheckBox cboxOverwrite = new JCheckBox("Overwrite Quantity?");
		GridBagConstraints gbc_cboxOverwrite = new GridBagConstraints();
		gbc_cboxOverwrite.insets = new Insets(0, 0, 5, 0);
		gbc_cboxOverwrite.gridx = 0;
		gbc_cboxOverwrite.gridy = 2;
		contentPane.add(cboxOverwrite, gbc_cboxOverwrite);

		JSpinner spQty = new JSpinner();
		spQty.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_spQty = new GridBagConstraints();
		gbc_spQty.insets = new Insets(0, 0, 5, 0);
		gbc_spQty.gridx = 0;
		gbc_spQty.gridy = 3;
		contentPane.add(spQty, gbc_spQty);

		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MedicineRequest r = MedicineRequests.get(lstMedicines.getSelectedIndex());
				int qty = r.getRQty();
				//Checks if quantity is being overwritten
				if (cboxOverwrite.isSelected()) {
					qty = (int) spQty.getValue();
				}
				//Create the new medicine with this stock
				Medicine m = new Medicine(r.getName(), qty);
				DataManager.AddMedicine(m);
				model.remove(lstMedicines.getSelectedIndex());
				DataManager.RemoveMedicineRequest(r);
				MedicineRequests.remove(r);

			}
		});
		GridBagConstraints gbc_btnApprove = new GridBagConstraints();
		gbc_btnApprove.insets = new Insets(0, 0, 5, 0);
		gbc_btnApprove.gridx = 0;
		gbc_btnApprove.gridy = 4;
		contentPane.add(btnApprove, gbc_btnApprove);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SectetaryScreen ss = new SectetaryScreen();
				ss.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 5;
		contentPane.add(btnBack, gbc_btnBack);
	}

}
