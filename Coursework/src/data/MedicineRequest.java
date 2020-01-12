package data;

public class MedicineRequest {

	private String name;
	private int requestedQuantity;
	
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
