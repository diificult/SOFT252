package data;

public class Medicine {

	private String name;
	private int stock;

	public Medicine(String name, int stock) {
		this.name = name;
		this.stock = stock;
	}

	public Medicine(String name) {
		this.name = name;
	}

	public String GetName() {
		return name;
	}

	public int GetStock() {
		return stock;
	}

	//If the user wants to remove the stock
	public boolean RemoveStock(int qty) {
		//If the qty is too much then say that they cant have that stock
		if (qty > stock) {
			return false;
			//This is if there is enough stock
		} else if (qty == stock) {
			//Remove the medicine as it is empty
			DataManager.RemoveMedicine(this);
			//Return that the stock has been got
			return true;
		} else {
			//Otherwise remove the stock and say the stock has been got
			stock -= qty;
			return true;
		}
	}

	// This one is like the one above, but can use this one to set to true if they
	// just want to remove all of the stock rather then not remove any at all
	public int RemoveStock(int qty, boolean returnMax) {
		//If the qty is more to the stock then the stock and the user just wants to get the most
		//or the stock is enough
		if ((qty > stock && returnMax) || (qty == stock)) {
			//Remove the medicine as it is empty
			DataManager.RemoveMedicine(this);
			//Return how much was got
			return stock;
		} else {
			//Otherwise remove the stock and return how much was got
			stock -= qty;
			return qty;
		}
	}

}
