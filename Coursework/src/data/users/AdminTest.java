package data.users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdminTest {

	private Admin a;
	@BeforeEach
	void setUp() {
		a = new Admin("TestName", "TestSurname", "TestID", "TestAddress", "TestPassword");
	}

	@Test
	void testGetName() {
		assertEquals("TestName", a.getName());
	}
	
	@Test
	void testGetSurname() {
		assertEquals("TestSurname", a.getSurname());
	}
	
	@Test 
	void testGetID() {
		assertEquals("TestID", a.getID());
	}
	
	@Test
	void testGetAddress() {
		assertEquals("TestAddress", a.getAddress());
	}
	
	@Test
	void testGetPassword() {
		assertEquals("TestPassword", a.getPassword());
	}

}
