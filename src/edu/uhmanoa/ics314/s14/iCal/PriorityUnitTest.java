package edu.uhmanoa.ics314.s14.iCal;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Priority class.
 * Priority class handles converting priority level from UI 
 * to valid iCalendar specifications for event priority.
 * @author Alex Shum
 */
public class PriorityUnitTest {

	@Test
	public void testEmptyConstructor() {
		Priority p = new Priority();
		assertTrue(p.toString().equals("0"));
	}

	@Test
	public void testString1() {
		Priority p = new Priority("5");
		assertTrue(p.toString().equals("5"));
	}

	@Test
	public void testString2() {
		Priority p = new Priority("0dlkjfs[][");
		assertTrue(p.toString().equals("0"));
	}

	@Test
	public void testInt1() {
		Priority p = new Priority(5);
		assertTrue(p.toString().equals("5"));
	}

	@Test
	public void testInt2() {
		Priority p = new Priority(9);
		assertTrue(p.toString().equals("9"));
	}


	@Test(expected=IllegalArgumentException.class)
	public void testException1() {
		Priority p = new Priority("-5");
		assertTrue(p.toString().equals("-5"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testException2() {
		Priority p = new Priority("10");
		assertTrue(p.toString().equals("10"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testException3() {
		Priority p = new Priority(10);
		assertTrue(p.toString().equals("10"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testException4() {
		Priority p = new Priority(0);
		assertTrue(p.priorityLevel().equals("0"));
	}

	@Test
	public void testPriorityLevel1() {
		Priority p = new Priority("1");
		assertTrue(p.priorityLevel().equals("HIGH"));
	}

	@Test
	public void testPriorityLevel2() {
		Priority p = new Priority(5);
		assertTrue(p.priorityLevel().equals("MEDIUM"));
	}

	@Test
	public void testPriorityLevel3() {
		Priority p = new Priority(9);
		assertTrue(p.priorityLevel().equals("LOW"));
	}



}
