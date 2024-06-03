
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents test cases for a Plot object.
 */
public class PlotTestStudent {
	private Plot plot1, plot2;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(1, 1, 2, 2);
		plot2 = new Plot(2, 2, 1, 1);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot2 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot2)); // plot5 is entirely inside plot1
	}
	
	@Test
	public void testToString() {
		assertEquals("2,2,1,1",plot2.toString());	
	}

}
