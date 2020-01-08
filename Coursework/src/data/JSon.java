package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import data.users.Admin;
import data.users.Doctor;
import data.users.Patient;
import data.users.Secretary;

public class JSon {

	
	
	public static void storeRequestAccount(ArrayList<AccountRequest> ar) {
		GsonBuilder gb = new GsonBuilder();
		gb.serializeNulls();
		gb.setPrettyPrinting();
		Gson RequestAccount = gb.create();
		FileWriter fw;
		try {
			fw = new FileWriter("RequestAccount.json");
			
			RequestAccount.toJson(ar, fw);
			
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	
	private static final Type ACCOUNTREQUEST_TYPE = new TypeToken<ArrayList<AccountRequest>>() {
	}.getType();
	
	public static ArrayList<AccountRequest> getRequestAccounts() {
		Gson gson = new Gson();
		ArrayList<AccountRequest> request = new ArrayList<AccountRequest>();
		try {
			JsonReader jr = new JsonReader(new FileReader("RequestAccount.json"));
			 request = gson.fromJson(jr, ACCOUNTREQUEST_TYPE);
		} catch (FileNotFoundException e) {
			File file = new File("RequestAccount.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return request;
	}
	
	public static void storePatients(ArrayList<Patient> ar) {
		GsonBuilder gb = new GsonBuilder();
		gb.serializeNulls();
		gb.setPrettyPrinting();
		Gson Patient = gb.create();
		FileWriter fw;
		try {
			fw = new FileWriter("Patients.json");
			
			Patient.toJson(ar, fw);
			
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	
	private static final Type PATIENT_TYPE = new TypeToken<ArrayList<Patient>>() {
	}.getType();
	
	public static ArrayList<Patient> getPatients() {
		Gson gson = new Gson();
		ArrayList<Patient> request = new ArrayList<Patient>();
		try {
			JsonReader jr = new JsonReader(new FileReader("Patients.json"));
			 request = gson.fromJson(jr, PATIENT_TYPE);
		} catch (FileNotFoundException e) {
			File file = new File("Patients.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return request;
	}
	
	public static void storeDoctors(ArrayList<Doctor> ar) {
		GsonBuilder gb = new GsonBuilder();
		gb.serializeNulls();
		gb.setPrettyPrinting();
		Gson Doctors = gb.create();
		FileWriter fw;
		try {
			fw = new FileWriter("Doctors.json");
			
			Doctors.toJson(ar, fw);
			
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	
	private static final Type Doctor_TYPE = new TypeToken<ArrayList<Doctor>>() {
	}.getType();
	
	public static ArrayList<Doctor> getDoctors() {
		Gson gson = new Gson();
		ArrayList<Doctor> request = new ArrayList<Doctor>();
		try {
			JsonReader jr = new JsonReader(new FileReader("Doctors.json"));
			 request = gson.fromJson(jr, Doctor_TYPE);
		} catch (FileNotFoundException e) {
			File file = new File("Doctors.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return request;
	}
	public static void storeSecretarys(ArrayList<Secretary> ar) {
		GsonBuilder gb = new GsonBuilder();
		gb.serializeNulls();
		gb.setPrettyPrinting();
		Gson RequestAccount = gb.create();
		FileWriter fw;
		try {
			fw = new FileWriter("Secretarys.json");
			
			RequestAccount.toJson(ar, fw);
			
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	
	private static final Type Secretary_TYPE = new TypeToken<ArrayList<Secretary>>() {
	}.getType();
	
	public static ArrayList<Secretary> getSecretarys() {
		Gson gson = new Gson();
		ArrayList<Secretary> request = new ArrayList<Secretary>();
		try {
			JsonReader jr = new JsonReader(new FileReader("Secretarys.json"));
			 request = gson.fromJson(jr, Secretary_TYPE);
		} catch (FileNotFoundException e) {
			File file = new File("Secretarys.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return request;
	}
	
	public static void storeAdmins(ArrayList<Admin> ar) {
		GsonBuilder gb = new GsonBuilder();
		gb.serializeNulls();
		gb.setPrettyPrinting();
		Gson Admins = gb.create();
		FileWriter fw;
		System.out.println(ar.get(0).getID());
		try {
			fw = new FileWriter("Admins.json");
			Admins.toJson(ar, fw);
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	
	private static final Type ADMIN_TYPE = new TypeToken<ArrayList<Admin>>() {
	}.getType();
	
	public static ArrayList<Admin> getAdmins() {
		Gson gson = new Gson();
		ArrayList<Admin> request = new ArrayList<Admin>();
		try {
			JsonReader jr = new JsonReader(new FileReader("Admins.json"));
			 request = gson.fromJson(jr, ADMIN_TYPE);
		} catch (FileNotFoundException e) {
			File file = new File("Admins.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return request;
	}
	
}
