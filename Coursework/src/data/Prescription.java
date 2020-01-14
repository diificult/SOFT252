package data;

import java.util.Date;

public class Prescription {
	private String DoctorID;
	private String PatientID;
	private String DoctorNote;
	private Medicine medicine;
	private int Quantity;
	private String Dosage;
	private Date date;

	public Prescription(String DoctorID, String PatientID, String DoctorNote, Medicine medicine, int Quantity,
			String Dosage, Date date) {
		this.DoctorID = DoctorID;
		this.PatientID = PatientID;
		this.DoctorNote = DoctorNote;
		this.medicine = medicine;
		this.Quantity = Quantity;
		this.Dosage = Dosage;
		this.date = date;
	}

	public Prescription(String DoctorID, String PatientID, String DoctorNote, Date date) {
		this.DoctorID = DoctorID;
		this.PatientID = PatientID;
		this.DoctorNote = DoctorNote;
		this.date = date;
	}

	public String GetDoctorID() {
		return DoctorID;
	}

	public String GetPatientID() {
		return DoctorNote;
	}

	public String GetDoctorNote() {
		return DoctorNote;
	}

	public Medicine GetMedicine() {
		return medicine;
	}

	public int GetQuantity() {
		return Quantity;
	}

	public String GetDosage() {
		return Dosage;
	}

	public Date GetDate() {
		return date;
	}

}
