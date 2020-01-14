package data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class MedicineTest {

	private Medicine m;

	@Before
	public void setUp() {
		m = new Medicine("Med", 5);
	}

	@Test
	void RemoveStockTest() {

		assertEquals(5, m.RemoveStock(6, true));

		assertEquals(5, m.RemoveStock(5, true));

		assertEquals(4, m.RemoveStock(4, true));

		assertEquals(0, m.RemoveStock(5, false));
	}

}
