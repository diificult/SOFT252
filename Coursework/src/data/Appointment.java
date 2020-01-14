package data;

import java.util.Date;

public class Appointment {

	private String DoctorID;
	private String PatientID;
	private Date date;

	public Appointment(String DoctorID, String PatientID, Date date) {
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
