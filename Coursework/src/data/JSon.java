package data;

import java.lang.reflect.Type;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import data.users.Patient;

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
			e.printStackTrace();
		}
		
		return request;
	}
	
	public static void storePatients(ArrayList<Patient> ar) {
		GsonBuilder gb = new GsonBuilder();
		gb.serializeNulls();
		gb.setPrettyPrinting();
		Gson RequestAccount = gb.create();
		FileWriter fw;
		try {
			fw = new FileWriter("Patients.json");
			
			RequestAccount.toJson(ar, fw);
			
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	
	private static final Type PATIENT_TYPE = new TypeToken<ArrayList<Patient>>() {
	}.getType();
	
	public static ArrayList<Patient> getPatientS() {
		Gson gson = new Gson();
		ArrayList<Patient> request = new ArrayList<Patient>();
		try {
			JsonReader jr = new JsonReader(new FileReader("Patients.json"));
			 request = gson.fromJson(jr, PATIENT_TYPE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return request;
	}
	
	
}
