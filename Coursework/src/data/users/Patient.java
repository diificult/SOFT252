package data.users;

import java.util.ArrayList;

import data.Appointment;
import data.Observable;
import data.Observer;

public class Patient implements iUser, Observer {

	// Usual details plus age & gender
	private String name;
	private String surname;
	private String id;
	private String address;
	private int age;
	private char gender;
	private String password;
	// Patient notification system
	private ArrayList<Appointment> AppointmentNotification = new ArrayList<Appointment>();

	public Patient(String name, String surname, String id, String address, int age, char gender, String password) {
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.password = password;
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
	
	public int getAge() {
		return age;
	}
	public char getGender() {
		return gender;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public ArrayList<Appointment> getNotification() {
		return AppointmentNotification;
	}

	public void RemoveNotifications() {
		AppointmentNotification = new ArrayList<Appointment>();
	}

	@Override
	public void update(ArrayList<Appointment> a, Observable o) {
		// If the list is empty it must be made into a new array list as it will cause
		// errors
		if (AppointmentNotification == null)
			AppointmentNotification = new ArrayList<Appointment>();
		// Adds all of the appointment updates
		AppointmentNotification.addAll(a);
		// Removes this from the observer as it doesnt need anymore updates from this
		// appointment
		o.removeObserver(this);

	}

}
