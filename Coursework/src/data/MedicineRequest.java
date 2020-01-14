package data;

public class MedicineRequest {

	//Data
	private String name;
	private int requestedQuantity;

	//Creates the object
	public MedicineRequest(String name, int qty) {
		this.name = name;
		requestedQuantity = qty;
	}

	public String getName() {
		return name;
	}

	public int getRQty() {
		return requestedQuantity;
	}

}
