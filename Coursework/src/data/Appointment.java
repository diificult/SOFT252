package data;

import java.util.Date;

public class Appointment {

	//Creates an appointment with the doctor ID, Patient ID, and on that specific date
	private String DoctorID;
	private String PatientID;
	private Date date;

	public Appointment(String DoctorID, String PatientID, Date date) {
		//this. shows that its the one from the class otherwise it thinks its one of the args
		this.DoctorID = DoctorID;
		this.PatientID = PatientID;
		this.date = date;
	}

	public String GetDoctorID() {
		return DoctorID;
	}

	public String GetPatientID() {
		return PatientID;
	}

	public Date GetDate() {
		return date;
	}

}
