package data.users;

import data.AccountRequest;

public interface iUserFactory {

	// Interface for factory, Two types of create user as one for patient and one
	// for the other types
	static void CreateUser(String type, String name, String surname, String address, String password) {
	}

	static void CreateUser(String name, String surname, String address, int age, char gender, String password) {
	}
}
