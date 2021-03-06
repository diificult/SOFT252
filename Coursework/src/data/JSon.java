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

	//This is all the JSON that is used. Each section uses its own code. 
	//Didnt get round to making it into two methods imputing the type to minimise this code
	
	//This is the code for all of the "Store" methods
	public static void storeRequestAccount(ArrayList<AccountRequest> ar) {
		//Creates a new method that is a JSON builder. This turns the data into JSON
		GsonBuilder gb = new GsonBuilder();
		// Allows nulls to be serialized into the data
		gb.serializeNulls();
		// Makes the JSON look good and readable
		gb.setPrettyPrinting();
		//Now makes the GSON type with the builder we made/
		Gson RequestAccount = gb.create();
		FileWriter fw;
		try {
			//Gets the file into a file writer
			fw = new FileWriter("RequestAccount.json");
			//Turns the data into JSON
			RequestAccount.toJson(ar, fw);

			//Flushes the data buffer to make sure it goes into the fle
			fw.flush();
			//Closes the file writer
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	//Gets the type for this ArrayList
	private static final Type ACCOUNTREQUEST_TYPE = new TypeToken<ArrayList<AccountRequest>>() {
	}.getType();

	//This is the method used for all the "Get"ting of the data
	public static ArrayList<AccountRequest> getRequestAccounts() {
		//Creatsa new GSON type
		Gson gson = new Gson();
		//Stores the requested data
		ArrayList<AccountRequest> request = new ArrayList<AccountRequest>();
		try {
			//Tries to start a json reader and with the file
			JsonReader jr = new JsonReader(new FileReader("RequestAccount.json"));
			//Converts the data into arraylists
			request = gson.fromJson(jr, ACCOUNTREQUEST_TYPE);
		} catch (FileNotFoundException e) {
			//If there is an exception due to file not existing then create a new file
			File file = new File("RequestAccount.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//returnss the data
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

	public static void storeRequestApp(ArrayList<RequestedAppointment> ra) {
		GsonBuilder gb = new GsonBuilder();
		gb.serializeNulls();
		gb.setPrettyPrinting();
		Gson Admins = gb.create();
		FileWriter fw;
		try {
			fw = new FileWriter("RequestedAppointments.json");
			Admins.toJson(ra, fw);
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static final Type REQUESTEDAPPOINTMENT_TYPE = new TypeToken<ArrayList<RequestedAppointment>>() {
	}.getType();

	public static ArrayList<RequestedAppointment> getRequestedAppointments() {
		Gson gson = new Gson();
		ArrayList<RequestedAppointment> request = new ArrayList<RequestedAppointment>();
		try {
			JsonReader jr = new JsonReader(new FileReader("RequestedAppointments.json"));
			request = gson.fromJson(jr, REQUESTEDAPPOINTMENT_TYPE);
		} catch (FileNotFoundException e) {
			File file = new File("RequestedAppointments.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		return request;
	}

	public static void storeAppointment(ArrayList<Appointment> ra) {
		GsonBuilder gb = new GsonBuilder();
		gb.serializeNulls();
		gb.setPrettyPrinting();
		Gson Admins = gb.create();
		FileWriter fw;
		try {
			fw = new FileWriter("Appointments.json");
			Admins.toJson(ra, fw);
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static final Type APPOINTMENT_TYPE = new TypeToken<ArrayList<Appointment>>() {
	}.getType();

	public static ArrayList<Appointment> getAppointments() {
		Gson gson = new Gson();
		ArrayList<Appointment> request = new ArrayList<Appointment>();
		try {
			JsonReader jr = new JsonReader(new FileReader("Appointments.json"));
			request = gson.fromJson(jr, APPOINTMENT_TYPE);
		} catch (FileNotFoundException e) {
			File file = new File("Appointments.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		return request;
	}

	public static void storeMedicine(ArrayList<Medicine> ra) {
		GsonBuilder gb = new GsonBuilder();
		gb.serializeNulls();
		gb.setPrettyPrinting();
		Gson Admins = gb.create();
		FileWriter fw;
		try {
			fw = new FileWriter("Medicines.json");
			Admins.toJson(ra, fw);
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static final Type MEDICINE_TYPE = new TypeToken<ArrayList<Medicine>>() {
	}.getType();

	public static ArrayList<Medicine> getMedicine() {
		Gson gson = new Gson();
		ArrayList<Medicine> request = new ArrayList<Medicine>();
		try {
			JsonReader jr = new JsonReader(new FileReader("Medicines.json"));
			request = gson.fromJson(jr, MEDICINE_TYPE);
		} catch (FileNotFoundException e) {
			File file = new File("Medicines.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		return request;
	}

	public static void storeMedicineRequest(ArrayList<MedicineRequest> ra) {
		GsonBuilder gb = new GsonBuilder();
		gb.serializeNulls();
		gb.setPrettyPrinting();
		Gson requests = gb.create();
		FileWriter fw;
		try {
			fw = new FileWriter("MedicineRequests.json");
			requests.toJson(ra, fw);
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static final Type MEDICINEREQUEST_TYPE = new TypeToken<ArrayList<MedicineRequest>>() {
	}.getType();

	public static ArrayList<MedicineRequest> getMedicineRequest() {
		Gson gson = new Gson();
		ArrayList<MedicineRequest> request = new ArrayList<MedicineRequest>();
		try {
			JsonReader jr = new JsonReader(new FileReader("MedicineRequests.json"));
			request = gson.fromJson(jr, MEDICINEREQUEST_TYPE);
		} catch (FileNotFoundException e) {
			File file = new File("MedicineRequests.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		return request;
	}

	public static void storePrescription(ArrayList<Prescription> ra) {
		GsonBuilder gb = new GsonBuilder();
		gb.serializeNulls();
		gb.setPrettyPrinting();
		Gson requests = gb.create();
		FileWriter fw;
		try {
			fw = new FileWriter("Prescriptions.json");
			requests.toJson(ra, fw);
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static final Type PRESCRIPTION_TYPE = new TypeToken<ArrayList<Prescription>>() {
	}.getType();

	public static ArrayList<Prescription> getPrescription() {
		Gson gson = new Gson();
		ArrayList<Prescription> request = new ArrayList<Prescription>();
		try {
			JsonReader jr = new JsonReader(new FileReader("Prescriptions.json"));
			request = gson.fromJson(jr, PRESCRIPTION_TYPE);
		} catch (FileNotFoundException e) {
			File file = new File("Prescription.json");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		return request;
	}

}
