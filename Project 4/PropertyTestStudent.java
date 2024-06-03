
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents test cases for a Property object.
 */
class PropertyTestStudent {
	Property propertyOne;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("Test Property", "Silver Spring", 1000.05, "Dolev Peleg");
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Test Property", propertyOne.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(1000.05, propertyOne.getRentAmount());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("Property Name: Test Property\nLocated in: Silver Spring\nBelongs to: Dolev Peleg\nRent Amount: 1000.05\n" ,propertyOne.toString());	
	}

}
