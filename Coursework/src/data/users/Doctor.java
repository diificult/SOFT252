package data.users;

public class Doctor implements iUser {

	private static String name;
	private static String surname;
	private static String id;
	private static String address;
	private static String password;
	
	public Doctor(String name, String surname, String id, String address, String password) {
		this.name= name;
		this.surname= surname;
		this.id= id;
		this.address=  address;
		this.password= password;
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
