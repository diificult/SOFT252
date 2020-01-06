package data.users;

import data.AccountRequest;

public interface iUserFactory {

	public void ApproveUser(AccountRequest ar);

	void CreateUser(String type, String name, String surname, String address);
	
}
