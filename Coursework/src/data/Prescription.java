package data;

public class Prescription {
	private String DoctorID;
	private String PatientID;
	private String DoctorNote;
	private Medicine medicine;
	private int Quantity;
	private String Dosage;
	
	public void Prescription(String DoctorID, String PatientID,String DoctorNote, Medicine medicine, int Quantity, String Dosage) {
		this.DoctorID = DoctorID;
		this.PatientID = PatientID;
		this.DoctorNote = DoctorNote;
		this.medicine = medicine;
		this.Quantity = Quantity;
		this.Dosage = Dosage;
	}
}
