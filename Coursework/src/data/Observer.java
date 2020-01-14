package data;

import java.util.ArrayList;

public interface Observer {

	
	//Interface for observer who gets the data
	//from the observable
	public void update(ArrayList<Appointment> a, Observable o);

}
