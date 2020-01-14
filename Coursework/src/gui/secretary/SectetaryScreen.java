package gui.secretary;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SectetaryScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SectetaryScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		//Button to approve accounts
		JButton btnApprove = new JButton("Approve Accounts ");
		contentPane.add(btnApprove);
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApproveAccounts aa = new ApproveAccounts();
				aa.setVisible(true);
				dispose();
			}
		});

		//Button to view requested appointments
		JButton btnAppointments = new JButton("Appointment Requests");
		contentPane.add(btnAppointments);
		btnAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppointmentApproval aa = new AppointmentApproval();
				aa.setVisible(true);
				dispose();
			}
		});
		
		

		//Button to remove patients
		JButton btnRemove = new JButton("Remove Patients");
		contentPane.add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemovePatients rp = new RemovePatients();
				rp.setVisible(true);
				dispose();
			}
		});

		//Buttom to remove medicine
		JButton btnApproveMedicine = new JButton("Approve Medicine");
		contentPane.add(btnApproveMedicine);
		btnApproveMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApproveMedicine am = new ApproveMedicine();
				am.setVisible(true);
				dispose();
			}
		}

		);

	}

}
