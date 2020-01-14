package data;

public class Feedback {
	private String DoctorId;
	private int Rating;
	private String Feedback;

	//Feedback is a single bit of feedback from one person
	//This is currently not implemented
	public void Feedback(String DoctorId, int Rating, String Feedback) {
		this.DoctorId = DoctorId;
		this.Rating = Rating;
		this.Feedback = Feedback;
	}

	public int GetRating() {
		return Rating;
	}

	public String GetFeedback() {
		return Feedback;
	}

	public String GetID() {
		return DoctorId;
	}
}
