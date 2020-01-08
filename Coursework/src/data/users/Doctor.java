package data.users;

import java.util.ArrayList;

import data.Appointment;
import data.Observer;

public class Doctor implements iUser, Observer {

	private String name;
	private String surname;
	private String id;
	private String address;
	private String password;
	
	public Doctor(String name, String surname, String id, String address, String password) {
		this.name= name;
		this.surname= surname;
		this.id= id;
		this.address=  address;
		this.password= password;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String getSurname() {
		return surname;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void update(ArrayList<Appointment> a) {
		// TODO Auto-generated method stub
		
	}

	
	
}
