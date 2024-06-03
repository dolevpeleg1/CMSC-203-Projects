
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	Property p1, p2, p3, p4, p5;
	ManagementCompany mangementCo ; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo = new ManagementCompany("TestCompany", "3124",12);
	}

	@After
	public void tearDown() throws Exception {
		mangementCo = null;
	}

	@Test
	public void testAddProperty() {
		p1 = new Property ("p1", "Silver Spring", 1000.5, "Dolev Peleg",1,1,3,3);
		p2 = new Property ("p2", "Silver Spring", 867.05, "Dolev Peleg",2,2,3,3);
		p3 = new Property ("p3", "Silver Spring", 120, "Dolev Peleg",2,6,15,15);
		assertEquals(mangementCo.addProperty(p1), 0);	//property has been successfully added to index 0
		assertEquals(mangementCo.addProperty(p2),-4);	//property overlaps another property
		assertEquals(mangementCo.addProperty(p3),-3);	//property is not encompassed by the company
		
	}
	
	@Test
	public void testRemoveLastProperty() {
		p1 = new Property ("p1", "Silver Spring", 111, "Peleg Dolev",1,3,3,4);
		assertEquals(mangementCo.addProperty(p1), 0); // Adding p1 to the company
		mangementCo.removeLastProperty(); // Adding p1 to the company
		assertEquals(mangementCo.getPropertiesCount(), 0); // The amount of properties in the company is now 0
	}
	
	@Test
	public void testTsPropertiesFullAndRentValues() {
		p1 = new Property ("p1", "Silver Spring", 100, "Dolev Peleg",1,1,1,1);
		p2 = new Property ("p2", "Silver Spring", 200, "Dolev Peleg",2,2,1,1);
		p3 = new Property ("p3", "Silver Spring", 300, "Dolev Peleg",3,3,1,1);
		p4 = new Property ("p4", "Silver Spring", 400, "Dolev Peleg",4,4,1,1);
		p5 = new Property ("p5", "Silver Spring", 500, "Dolev Peleg",5,5,1,1);
		assertEquals(mangementCo.addProperty(p1), 0);	// Property has been successfully added to index 0
		assertEquals(mangementCo.addProperty(p2), 1);	// Property has been successfully added to index 1
		assertEquals(mangementCo.addProperty(p3), 2);	// Property has been successfully added to index 2
		assertEquals(mangementCo.addProperty(p4), 3);	// Property has been successfully added to index 3
		assertEquals(mangementCo.addProperty(p5), 4);	// Property has been successfully added to index 4
		assertEquals(mangementCo.isPropertiesFull(), true); // The properties list is now full
		assertEquals(mangementCo.getHighestRentPropperty(), mangementCo.getProperties()[4]); // Property at index 4 has the highest rent
		assertEquals(mangementCo.getTotalRent(), 1500.0, 0); // The total rent is 1500
	}
	
	
	
	@Test
	public void testGetPropertiesCount() {
		p1 = new Property ("p1", "Silver Spring", 111, "Peleg Dolev",1,3,3,4);
		p2 = new Property ("p2", "Silver Spring", 1, "Dolev Peleg",4,1,2,2);
		assertEquals(mangementCo.addProperty(p1), 0);	// Adding p1 to the company
		assertEquals(mangementCo.addProperty(p2), 1);	// Adding p2 to the company
		assertEquals(mangementCo.getPropertiesCount(), 2);	// The amount of properties in the company is now 2
	}
	
	public void testGetHighestRent() {
		p1 = new Property ("p1", "Silver Spring", 111, "Peleg Dolev",1,3,3,4);
		p2 = new Property ("p2", "Silver Spring", 1, "Dolev Peleg",4,1,2,2);
		assertEquals(mangementCo.addProperty(p1), 0);	
		assertEquals(mangementCo.addProperty(p2), 1);	
		assertEquals(mangementCo.getPropertiesCount(), 2);
	}

	@Test
	public void testToString() {
		p1 = new Property ("p1", "Silver Spring", 1000.5, "Dolev Peleg",1,1,3,3);
		assertEquals(mangementCo.addProperty(p1), 0);	//property has been successfully added to index 0
		
		String expectedString = "List of the properties for TestCompany, taxID: 3124\n_____________________________________________\n"
				+ "Property Name: p1\nLocated in: Silver Spring\nBelongs to: Dolev Peleg\nRent Amount: 1000.5\n\n_____________________________________________\n\ntotal management Fee: 12.0";
		assertEquals(expectedString, mangementCo.toString());
	}
}
