package data; 
import data.JSon;
import data.users.*;

import java.util.ArrayList;

public class DataManager {
	
	private static ArrayList<AccountRequest> RequestedAccounts = new ArrayList<AccountRequest>();
	private static ArrayList<Patient> Patients = new ArrayList<	Patient>();
	private static ArrayList<Doctor> Doctors = new ArrayList<Doctor>();
	private static ArrayList<Secretary> Secretarys = new ArrayList<Secretary>();
	private static ArrayList<Admin> Admins = new ArrayList<Admin>();
	
	
	public static void LoadData() {
		RequestedAccounts = JSon.getRequestAccounts();
	}
	
	public static void AddAccountRequest(AccountRequest ar) {
		RequestedAccounts.add(ar);
		JSon.storeRequestAccount(RequestedAccounts);
		
	}
	
	public static ArrayList<AccountRequest> GetAccountRequests() {
		return RequestedAccounts;
	}
	
	public static void AddPatient(Patient p) {
		Patients.add(p);
		JSon.storePatients(Patients);
		
	}
	
	public static ArrayList<Patient> GetPatients() {
		return Patients;
	}
	
	public static void AddDoctor(Doctor d) {
		Doctors.add(d);
		JSon.storeDoctors(Doctors);
		
	}
	
	public static ArrayList<Doctor> GetDoctors() {
		return Doctors;
	}

	public static void AddSecretary(Secretary s) {
		Secretarys.add(s);
		JSon.storeSecretarys(Secretarys);
		
	}
	
	public static ArrayList<Secretary> GetSecretarys() {
		return Secretarys;
	}
	
	public static void AddAdmin(Admin a) {
		Admins.add(a);
		JSon.storeAdmins(Admins);
		
	}
	
	public static ArrayList<Admin> GetAdmins() {
		return Admins;
	}
	
}
