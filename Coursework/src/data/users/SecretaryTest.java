package data.users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SecretaryTest {

	private Secretary s;
	@BeforeEach
	void setUp() {
		s = new Secretary("TestName", "TestSurname", "TestID", "TestAddress", "TestPassword");
	}

	@Test
	void testGetName() {
		assertEquals("TestName", s.getName());
	}
	
	@Test
	void testGetSurname() {
		assertEquals("TestSurname", s.getSurname());
	}
	
	@Test 
	void testGetID() {
		assertEquals("TestID", s.getID());
	}
	
	@Test
	void testGetAddress() {
		assertEquals("TestAddress", s.getAddress());
	}
	
	@Test
	void testGetPassword() {
		assertEquals("TestPassword", s.getPassword());
	}

}
