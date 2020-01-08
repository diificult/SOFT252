package data.users;

import java.util.ArrayList;

import data.Appointment;
import data.Observable;
import data.Observer;

public class Doctor implements iUser, Observer {

	private String name;
	private String surname;
	private String id;
	private String address;
	private String password;
	private ArrayList<Appointment> AppointmentNotification = new ArrayList<Appointment>();
	
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

	public void RemoveNotifications() {
		AppointmentNotification = new ArrayList<Appointment>();
	}
	
	
	public ArrayList<Appointment> getNotification() {
		return AppointmentNotification;
	}
	
	@Override
	public void update(ArrayList<Appointment> a, Observable o) {
		if (AppointmentNotification == null ) AppointmentNotification = new ArrayList<Appointment>();
		AppointmentNotification.addAll(a);
		o.removeObserver(this);
	}

	
	
}
