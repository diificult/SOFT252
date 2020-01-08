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
	private static ArrayList<RequestedAppointment> RequestedAppointments = new ArrayList<RequestedAppointment>();
	
	
	public static void LoadData() {
		RequestedAccounts = JSon.getRequestAccounts();
		Patients = JSon.getPatients();
		Doctors = JSon.getDoctors();
		Secretarys = JSon.getSecretarys();
		Admins = JSon.getAdmins();
		RequestedAppointments = JSon.getRequestedAppointments();
		
		
	}
	
	public static void AddAccountRequest(AccountRequest ar) {
		RequestedAccounts.add(ar);
		JSon.storeRequestAccount(RequestedAccounts);
		
	}
	public static void RemoveAccountRequest(AccountRequest ar) {
		RequestedAccounts.remove(ar);
		JSon.storeRequestAccount(RequestedAccounts);
		
	}
	
	public static ArrayList<AccountRequest> GetAccountRequests() {
		return RequestedAccounts;
	}
	
	public static void AddPatient(Patient p) {
		if (Patients == null) Patients = new ArrayList<Patient>();
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
	
	public static void RemoveDoctor(Doctor d) {
		Doctors.remove(d);
		JSon.storeDoctors(Doctors);
	}

	public static void AddSecretary(Secretary s) {
		if (Secretarys == null) Secretarys = new ArrayList<Secretary>();
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
	
	public static void AddRequestedAppointment(RequestedAppointment ra) {
		if (RequestedAppointments == null ) RequestedAppointments = new ArrayList<RequestedAppointment>();
		RequestedAppointments.add(ra);
		JSon.storeRequestApp(RequestedAppointments);
		
	}
	
	public static ArrayList<RequestedAppointment> GetRequestedAppointments() {
 		return RequestedAppointments;
	}
	
	
	
}
