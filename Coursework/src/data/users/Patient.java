package data.users;

public class Patient implements iUser{

	private String name;
	private String surname;
	private String id;
	private String address;
	private int age;
	private char gender;
	private String password;
	
	


	public Patient(String name,  String surname, String id, String address, int age, char gender,String password) {
		this.name = name;
		this.surname = surname;
		this.id =  id;
		this.address = address;
		this.age = age;
		this.gender = gender;	
		this.password = password;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getID() {
		return id;
	}
	@Override
	public String getSurname() {
		return surname;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
}
