package data.users;

import java.util.ArrayList;

import data.Appointment;
import data.Observable;
import data.Observer;

public class Doctor implements iUser, Observer {

	//Account Details
	private String name;
	private String surname;
	private String id;
	private String address;
	private String password;
	//List of notifications to be shown on load up
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

	//Removes the notifications when there are seen
	public void RemoveNotifications() {
		AppointmentNotification = new ArrayList<Appointment>();
	}
	
	
	//Gets the list of notifications
	public ArrayList<Appointment> getNotification() {
		return AppointmentNotification;
	}
	
	//When a notification gets sent
	@Override
	public void update(ArrayList<Appointment> a, Observable o) {
		//Adds to the list of notifications
		if (AppointmentNotification == null ) AppointmentNotification = new ArrayList<Appointment>();
		AppointmentNotification.addAll(a);
		//Removes this from the observer as it no longer needs updates from it for this appointment
		o.removeObserver(this);
	}

	
	
}
