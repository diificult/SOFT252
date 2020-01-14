package data;

public interface Observable {

	
	//Interface for observable
	//Reqired methods
	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObserver();

}
