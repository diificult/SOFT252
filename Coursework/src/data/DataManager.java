package data; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class DataManager {
	
	
	public static void main(String[] args) {
		File f = new File("RequestAccount.json");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		AccountRequest account1 = new AccountRequest("Big", "Boi","69  STEVE AV", 5, 'm',"password");
		
		AccountRequest account2 = new AccountRequest("Smol", "Boui","67  STEVE AV",47, 'f',"the");
		getRequestAccounts();
//		storeRequestAccount(account1);
//		storeRequestAccount(account2);
//		JSONArray ar = getRequestAccounts();
//		System.out.print(JSONArray.toJSONString(ar));
//		
	}
	
	public static void storeRequestAccount(AccountRequest ar) {
		JSONObject RequestAccount = new JSONObject();
	//	JSONArray RequestedAccounts =  getRequestAccounts();
		try {
		RequestAccount.put("name",              ar.GetName());
		RequestAccount.put("surname",ar.GetSurname());
		RequestAccount.put("address", ar.GetAddress());
		RequestAccount.put("age",ar.GetAge());
		RequestAccount.put("gender", Character.toString(ar.GetGender()));
		RequestAccount.put("password",ar.GetPassword());
	//	RequestedAccounts.add(RequestAccount);
		PrintWriter pw = new PrintWriter("RequestAccount.json");
		pw.write(RequestAccount.toJSONString());
		pw.close();
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static JSONArray getRequestAccounts() {
		ArrayList<AccountRequest> ara = new ArrayList<AccountRequest>();
		JSONArray ar = new JSONArray();
		Object Parser;
		try {
			FileReader r = new FileReader("RequestAccount.json");
			JSONParser p = new JSONParser();
			JSONObject ra = (JSONObject)p.parse(r);
			System.out.print(ra);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ar;
	}
	
}
