package edu.uhmanoa.ics314.s14.iCal;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClassificationUnitTest {
	@Test
	public void testPublic1() {
		Classification c = new Classification("public");
		assertTrue(c.toString().equals("PUBLIC"));
	}

	@Test
	public void testPublic2() {
		Classification c = new Classification("PUBLIC");
		assertTrue(c.toString().equals("PUBLIC"));
	}

	@Test
	public void testPublic3() {
		Classification c = new Classification("pUbLiC");
		assertTrue(c.toString().equals("PUBLIC"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPublic4() {
		Classification c = new Classification("pUbLic9213[]+");
		assertTrue(c.toString().equals("PUBLIC"));
	}

	@Test
	public void testPrivate1() {
		Classification c = new Classification("private");
		assertTrue(c.toString().equals("PRIVATE"));
	}

	@Test
	public void testPrivate2() {
		Classification c = new Classification("PRIVATE");
		assertTrue(c.toString().equals("PRIVATE"));
	}

	@Test
	public void testPrivate3() {
		Classification c = new Classification("pRiVaTe");
		assertTrue(c.toString().equals("PRIVATE"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPrivate4() {
		Classification c = new Classification("prIvAte38129{}-=");
		assertTrue(c.toString().equals("PRIVATE"));
	}

	@Test
	public void testConfidential1() {
		Classification c = new Classification("confidential");
		assertTrue(c.toString().equals("CONFIDENTIAL"));
	}

	@Test
	public void testConfidential2() {
		Classification c = new Classification("CONFIDENTIAL");
		assertTrue(c.toString().equals("CONFIDENTIAL"));
	}

	@Test
	public void testConfidential3() {
		Classification c = new Classification("coNfIdEnTIaL");
		assertTrue(c.toString().equals("CONFIDENTIAL"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConfidential4() {
		Classification c = new Classification("324[]-=ConFidenTial-=234");
		assertTrue(c.toString().equals("CONFIDENTIAL"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testOther1() {
		Classification c = new Classification("blahblah");
		assertTrue(c.toString().equals("PUBLIC"));
	}
}
