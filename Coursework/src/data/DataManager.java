package data; 
import data.JSon;
import data.users.Patient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.stream.JsonReader;

public class DataManager {
	
	private static ArrayList<AccountRequest> RequestedAccounts = new ArrayList<AccountRequest>();
	private static ArrayList<Patient> Patients = new ArrayList<Patient>();
	
	
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

}
