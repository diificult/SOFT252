package data.users;

import java.util.ArrayList;

import data.AccountRequest;
import data.DataManager;

public class UserFactory implements iUserFactory {

	@Override
	public void ApproveUser(AccountRequest ar) {
		
	}

	@Override
	public void CreateUser(String type,  String name, String surname, String address) {
		switch  (type) {
		case "Doctor" :
			break;
		case  "Admin" :  
			break;
		case "Secretary": 
			break;
			default : 
				System.out.print("Error with type of user");
		}
				
		
	}

	public void CreateUser(String name, String surname, String address, int age, char gender, String password) {
		ArrayList<Patient> ps = DataManager.GetPatients();
		String id = "P" + ps.size();
		Patient p = new Patient(name, surname,  id,address,  age, gender,password);
		
		
	}

	
}
