package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void test() {
		Person person = new Person("Tom", "Böhmermann");
		String firstName = "Jan";
		
		person.setFirstName(firstName);		
		assertEquals(firstName, person.getFirstName());
		
		assertNotEquals("Tom", person.getFirstName());
	}

}
