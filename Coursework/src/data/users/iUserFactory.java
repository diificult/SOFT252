package data.users;

import data.AccountRequest;

public interface iUserFactory {


	static void CreateUser(String type, String name, String surname, String address, String password) {}
	static void CreateUser(String name, String surname, String address, int age, char gender, String password) {}
}
