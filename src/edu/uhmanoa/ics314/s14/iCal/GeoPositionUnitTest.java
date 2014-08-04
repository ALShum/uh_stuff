package edu.uhmanoa.ics314.s14.iCal;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeoPositionUnitTest {

	@Test
	public void testValid1() {
		GeoPosition g = new GeoPosition("10;30");
		assertTrue(g.toString().equals("10.0;30.0"));
	}
	
	@Test
	public void testValid2() {
		GeoPosition g = new GeoPosition("-15;-20");
		assertTrue(g.toString().equals("-15.0;-20.0"));
	}
	
	@Test
	public void testValid3() {
		GeoPosition g = new GeoPosition("-10.5;40.2231");
		assertTrue(g.toString().equals("-10.5;40.2231"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalid1() {
		GeoPosition g = new GeoPosition("");
		assertTrue(g.toString().equals(""));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalid2() {
		GeoPosition g = new GeoPosition("100;-15");
		assertTrue(g.toString().equals("100.0;-15.0"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalid3() {
		GeoPosition g = new GeoPosition("20;-9000");
		assertTrue(g.toString().equals("20.0;-9000.0"));
	}
	
	@Test
	public void testEmptyConstructor() {
		GeoPosition g = new GeoPosition();
		assertTrue(g.toString().equals(""));
	}
	
	@Test
	public void testEmptyNumericConstructor() {
		GeoPosition g = new GeoPosition(10, 30);
		assertTrue(g.toString().equals("10.0;30.0"));
	}
	
	@Test
	public void testEmptyNumericConstructor2() {
		GeoPosition g = new GeoPosition(-10, -30);
		assertTrue(g.toString().equals("-10.0;-30.0"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidNumeric1() {
		GeoPosition g = new GeoPosition(20, -9000);
		assertTrue(g.toString().equals("20.0;-9000.0"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidNumeric2() {
		GeoPosition g = new GeoPosition(100,-15);
		assertTrue(g.toString().equals("100.0;-15.0"));
	}
	
}
