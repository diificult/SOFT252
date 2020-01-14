package data;

import java.util.Date;

public class RequestedAppointment {

	private String DoctorID;
	private String PatientID;
	private Date PotentialDate;

	public RequestedAppointment(String DoctorID, String PatientID, Date PotentialDate) {
		this.DoctorID = DoctorID;
		this.PatientID = PatientID;
		this.PotentialDate = PotentialDate;
	}

	public String GetDoctorID() {
		return DoctorID;
	}

	public String GetPatientID() {
		return PatientID;
	}

	public Date GetDate() {
		return PotentialDate;
	}

}
