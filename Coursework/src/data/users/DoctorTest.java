package data.users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoctorTest {

	private Doctor d;
	@BeforeEach
	void setUp() {
		d = new Doctor("TestName", "TestSurname", "TestID", "TestAddress", "TestPassword");
	}

	@Test
	void testGetName() {
		assertEquals("TestName", d.getName());
	}
	
	@Test
	void testGetSurname() {
		assertEquals("TestSurname", d.getSurname());
	}
	
	@Test 
	void testGetID() {
		assertEquals("TestID", d.getID());
	}
	
	@Test
	void testGetAddress() {
		assertEquals("TestAddress", d.getAddress());
	}
	
	@Test
	void testGetPassword() {
		assertEquals("TestPassword", d.getPassword());
	}

}
