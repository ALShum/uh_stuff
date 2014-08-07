package edu.uhmanoa.ics314.s14.iCal;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class DateTimeUnitTest {

	@Test
	public void testDefaultConstructor() {
		Calendar date = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
		DateTime dt = new DateTime();
		date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), 0, 0, 0);
		
		assertEquals(df.format(date.getTime()), dt.toString());
	}
	
	@Test
	//leaving out anything in caledar sets it to the current value according to computer's clock
	public void testDateFormat1() {
		Calendar date = Calendar.getInstance();
		date.set(1921, 07, 31, 00, 00, 00);
		DateTime dt = new DateTime(date);
		assertEquals(dt.toString(), "19210731T000000");
	}
	
	//handles 07-32
	@Test
	public void testDateFormat2() {
		Calendar date = Calendar.getInstance();
		date.set(1921, 07, 32, 00, 00, 00);
		DateTime dt = new DateTime(date);
		assertEquals(dt.toString(), "19210801T000000");
	}
	
	//also handles negative months
	@Test
	public void testDateFormat3() {
		Calendar date = Calendar.getInstance();
		date.set(1921, 12, -1, 00, 00, 00);
		DateTime dt = new DateTime(date);
		assertEquals(dt.toString(), "19211130T000000");
	}

	//automatically fixes 11-31 to 12-01
	@Test
	public void testYYMMDD1() {
		DateTime dt = new DateTime(1864, 11, 31);
		assertEquals(dt.toString(), "18641201T000000");
	}
	
	@Test
	public void testYYMMDD2() {
		DateTime dt = new DateTime(1864, 13, 32);
		assertEquals(dt.toString(), "18650201T000000");
	}
	
	@Test
	public void testYYMMDDHH1() {
		DateTime dt = new DateTime(1864, 05, 26, 25);
		assertEquals(dt.toString(), "18640527T010000");
	}
	
	//this also tests february for leap years
	@Test
	public void testYYMMDDHH2() {
		DateTime dt = new DateTime(1864, 02, 29, 13);
		assertEquals(dt.toString(), "18640229T130000");
	}
	
	//this also tests february for non-leap years 
	@Test
	public void testYYMMDDHHmm1() {
		DateTime dt = new DateTime(1865, 02, 29, 13, 59);
		assertEquals(dt.toString(), "18650301T135900");
	}	
	
	@Test
	public void testYYMMDDHHmm2() {
		DateTime dt = new DateTime(1865, 02, 01, 13, 61);
		assertEquals(dt.toString(), "18650201T140100");
	}
	
	@Test
	public void testYYMMDDHHmmss1() {
		DateTime dt = new DateTime(1865, 02, 01, 13, 59, 01);
		assertEquals(dt.toString(), "18650201T135901");
	}
	
	@Test
	public void testYYMMDDHHmmss2() {
		DateTime dt = new DateTime(1865, 02, 01, 13, 59, 61);
		assertEquals(dt.toString(), "18650201T140001");
	}
	
	@Test
	public void testString1() {
		DateTime dt = new DateTime("20120101");
		assertEquals(dt.toString(), "20120101T000000");
	}
	
	@Test
	public void testString2() {
		DateTime dt = new DateTime("20140203t130000");
		assertEquals(dt.toString(), "20140203T130000");
	}
	
	@Test
	public void testString3() {
		DateTime dt = new DateTime("20140203t135900");
		assertEquals(dt.toString(), "20140203T135900");
	}
	
	@Test
	public void testString4() {
		DateTime dt = new DateTime("20140203t135932");
		assertEquals(dt.toString(), "20140203T135932");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testException1() {
		DateTime dt = new DateTime("20140203135932");
		assertEquals(dt.toString(), "20140203T135932");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testException2() {
		DateTime dt = new DateTime("20140203T13593");
		assertEquals(dt.toString(), "20140203T13593");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testException3() {
		DateTime dt = new DateTime("20140203T135");
		assertEquals(dt.toString(), "20140203T135");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testException4() {
		DateTime dt = new DateTime("20140203T1");
		assertEquals(dt.toString(), "20140203T1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testException5() {
		DateTime dt = new DateTime("201402");
		assertEquals(dt.toString(), "201402");
	}
}
