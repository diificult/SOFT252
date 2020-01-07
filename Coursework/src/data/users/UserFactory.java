package data.users;

import java.util.ArrayList;

import data.DataManager;

public class UserFactory implements iUserFactory {

	public static void CreateUser(String type,  String name, String surname, String address,String password) {
		String  id;
		switch  (type) {
		case "Doctor" :
			ArrayList<Doctor>drs = DataManager.GetDoctors();
			id = "D" + String.format("%04d",drs.size());
			Doctor d = new Doctor(name,  surname, id,address, password);
			DataManager.AddDoctor(d);
			break;
		case  "Admin" :  
			ArrayList<Admin>ads = DataManager.GetAdmins();
			id = "A" + String.format("%04d",ads.size());
			Admin a= new Admin(name,  surname, id,address, password);
			DataManager.AddAdmin(a);
			break;
		case "Secretary": 
			ArrayList<Secretary>secs = DataManager.GetSecretarys();
			id = "A" + String.format("%04d",secs.size());
			Secretary s= new Secretary(name,  surname, id,address, password);
			DataManager.AddSecretary(s);
			break;
			default : 
				System.out.print("Error with type of user");
		}
				
		
	}

	public static void CreateUser(String name, String surname, String address, int age, char gender, String password) {
		ArrayList<Patient> ps = DataManager.GetPatients();
		String id = "P" + ps.size();
		Patient p = new Patient(name, surname,  id,address,  age, gender,password);
		DataManager.AddPatient(p);
		
		
	}


	
}
