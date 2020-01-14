package data.users;

public class Admin implements iUser {

	// Account details
	private String name;
	private String surname;
	private String id;
	private String address;
	private String password;

	public Admin(String name, String surname, String id, String address, String password) {
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.address = address;
		this.password = password;
	}

	// getters only

	public String getName() {
		return name;
	}

	public String getID() {
		return id;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

}
