package data;

public class AccountRequest {
		private String RequestedName;
		private String RequestedSurname;
		private String RequestedAddress;
		private int RequestedAge;
		private char RequestedGender;
		private String RequestedPassword;
		
		public AccountRequest(String name, String surname, String address, int age, char gender, String password) {
			this.RequestedName = name;
			this.RequestedSurname = surname;
			this.RequestedAddress  = address;
			this.RequestedAge = age;
			this.RequestedGender = gender;
			this.RequestedPassword = password;
		}
		
		public String GetName() {
			return RequestedName;
		}
		
		public String GetSurname()  {
			return RequestedSurname;
		}
		
		public String GetAddress() {
			return RequestedAddress;
		}
		
		public int GetAge() {
			return RequestedAge;
		}
		
		public char GetGender() {
			return RequestedGender;
		}
		
		public String GetPassword(){
			return RequestedPassword;
		}
}
