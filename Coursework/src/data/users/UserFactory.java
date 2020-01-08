package data.users;

import java.util.ArrayList;

import data.DataManager;

public class UserFactory implements iUserFactory {

	public static void CreateUser(String type,  String name, String surname, String address,String password) {
		String  id;
		switch  (type) {
		case "Doctor" :
			ArrayList<Doctor>drs = DataManager.GetDoctors();
			if (drs == null) id = "D0000";
			else id = "D" + String.format("%04d",Integer.parseInt(drs.get(drs.size()-1).getID().substring(1, 5))+1);
			Doctor d = new Doctor(name,  surname, id,address, password);
			DataManager.AddDoctor(d);
			break;
		case  "Admin" :  
			ArrayList<Admin>ads = DataManager.GetAdmins();
			if (ads  == null) id  = "A0000";
			else id = "A" + String.format("%04d",Integer.parseInt(ads.get(ads.size()-1).getID().substring(1, 5))+1);
			Admin a= new Admin(name,  surname, id,address, password);
			DataManager.AddAdmin(a);
			break;
		case "Secretary": 
			ArrayList<Secretary>secs = DataManager.GetSecretarys();
			if (secs == null) id = "S0000";
			else id = "S" + String.format("%04d",Integer.parseInt(secs.get(secs.size()-1).getID().substring(1, 5))+1);
			Secretary s= new Secretary(name,  surname, id,address, password);
			DataManager.AddSecretary(s);
			break;
			default : 
				System.out.print("Error with type of user");
		}
				
		
	}

	public static void CreateUser(String name, String surname, String address, int age, char gender, String password) {
		ArrayList<Patient> ps = DataManager.GetPatients();
		String  id;
		if (ps == null) id  = "P0000";
		else id ="P" + String.format("%04d",Integer.parseInt(ps.get(ps.size()-1).getID().substring(1, 5))+1);
		Patient p = new Patient(name, surname,  id,address,  age, gender,password);
		DataManager.AddPatient(p);
		
		
	}


	
}
