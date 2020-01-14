package data;

import java.util.ArrayList;

public class AppointmentNotification implements Observable {

	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	public AppointmentNotification() {

	}

	public void addAppointment(Appointment a) {
		appointments.add(a);
		notifyObserver();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);

	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(appointments, this);
		}

	}

}
