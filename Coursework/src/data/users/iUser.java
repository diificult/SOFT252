package data.users;

public interface iUser {
	// Interface for user. Must have these details
	static String name = "";
	static String id = "";
	static String surname = "";
	static String address = "";
	static String password = "";

	public String getName();

	public String getID();

	public String getSurname();

	public String getAddress();

	public String getPassword();
}
