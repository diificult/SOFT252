import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class JSONTEST {

	
	public static void main(String[] args) {
		Gson g = new Gson();
		
		try {
			FileWriter fw = new FileWriter("d.json");
			g.toJson(123.45, fw);
			fw.flush();
			fw.close();
			
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
