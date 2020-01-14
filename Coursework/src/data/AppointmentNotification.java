package data;

import java.util.ArrayList;

//Implements the observable interface
public class AppointmentNotification implements Observable {

	
	//Notification consists of some appointments and the observers
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	public AppointmentNotification() {

	}

	//Adds the appointments and updates the observers
	public void addAppointment(Appointment a) {
		appointments.add(a);
		notifyObserver();
	}

	//Adds the observers
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);

	}

	//Sends all of the observers the data
	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			//Sends the appointment and this class
			observer.update(appointments, this);
		}

	}

}
