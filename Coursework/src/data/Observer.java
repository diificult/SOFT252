package data;

import java.util.ArrayList;

public interface Observer {

	public void update(ArrayList<Appointment> a, Observable o);

}
