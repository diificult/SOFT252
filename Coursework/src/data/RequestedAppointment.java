package data;  
import java.util.Date;  

public class RequestedAppointment {

	private String DoctorID;
	private String PatientID;
	private Date PotentialDates;
	
	public void RequestedAppointment(String DoctorID,   String PatientID,  Date PotentialDates) {
		this.DoctorID = DoctorID;
		this.PatientID = PatientID;
		this.PotentialDates = PotentialDates;
	}
	
	
}
