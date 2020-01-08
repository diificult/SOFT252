package gui;

import data.DataManager;
import data.users.Admin;
import data.users.Doctor;
import data.users.Patient;
import data.users.Secretary;
import data.users.UserFactory;
import gui.admin.AdminScreen;
import gui.doctor.DoctorScreen;
import gui.patient.PatientScreen;
import gui.secretary.SectetaryScreen;

public class Main {

	private static Object Account = new Object();
	
	public static void main(String[] args) {
		MainScreen ms = new MainScreen();
		ms.setVisible(true);
		DataManager.LoadData();
	}
	
	public static void OpenLogin() {
		Login l = new Login();
		l.setVisible(true);
	}

	public static void OpenRegister()  {
		Register r = new Register();
		r.setVisible(true);
	}

	public static void OpenPatient(Patient p) {
		PatientScreen ps = new PatientScreen(p);
		ps.setVisible(true);
		Account =p;
	}
	
	public static void OpenSecretary(Secretary s) {
		SectetaryScreen ss = new SectetaryScreen();
		ss.setVisible(true);
		Account = s;
	}
	
	public static void OpenAdmin(Admin a) {
		AdminScreen as = new AdminScreen();
		as.setVisible(true);
		Account = a;
	}
	
	public static void OpenDoctor(Doctor d) {
		DoctorScreen ds = new DoctorScreen(d);
		ds.setVisible(true);
		Account = d;
	}
	
	public static Object getAccount() {
		return Account;
	}
}
