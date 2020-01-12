package data;

public class Medicine {

	private String name;
	private int stock;

	public Medicine(String name, int stock) {
		this.name = name;
		this.stock = stock;
	}

	public String GetName() {
		return name;
	}

	public int GetStock() {
		return stock;
	}

	public boolean RemoveStock(int qty) {
		if (qty > stock) {
			return false;
		}
		else if (qty == stock) {
			DataManager.RemoveMedicine(this);
			return true;
		}
		else {
			stock -= qty;
			return true;
		}
	}

	// This one is like the one above, but can use this one to set to true if they
	// just want to remove all of the stock rather then not remove any at all
	public int RemoveStock(int qty, boolean returnMax) {
		if (qty >= stock && returnMax) {
			DataManager.RemoveMedicine(this);
			return stock;
		}
		else {
			stock -= qty;
			return qty;
		}
	} 

}
