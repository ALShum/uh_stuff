package edu.uhmanoa.ics314.s14.iCal;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Timezone class.
 * Timezoneclass handles converting timezone locations from the UI 
 * to properly formatted iCalendar specifications for event time zone.
 * @author Alex Shum
 */
public class TimezoneUnitTest {
	//fast test
	public boolean test(String s) {
		Timezone t = new Timezone(s);
		return(s.toLowerCase().equals(t.toString()));
	}

	@Test
	public void testEmptyConstructor() {
		Timezone t = new Timezone();
		assertEquals(t.region, "Pacific");
		assertEquals(t.subregion, "Honolulu");
	}

	@Test
	public void testToStringDefault() {
		Timezone t = new Timezone();
		assertEquals(t.toString(), "Pacific/Honolulu");
	}

	@Test
	public void testTimezoneFormatAfrica() {
		String a = "Africa/Brazzaville";
		String b = "Africa/El_Aaiun";
		String c = "Africa/Dar_es_Salaam";

		assertTrue(test(a));
		assertTrue(test(b));
		assertTrue(test(c));
	}

	@Test
	public void testTimezoneFormatAmerica() {
		String a = "America/Toronto";
		String b = "America/Glace_Bay";
		String c = "America/Argentina/Buenos_Aires";
		String d = "America/Argentina/ComodRivadavia";
		String e = "America/Blanc-Sablon";
		String f = "America/Port-au-Prince";

		assertTrue(test(a));
		assertTrue(test(b));
		assertTrue(test(c));
		assertTrue(test(d));
		assertTrue(test(e));
		assertTrue(test(f));
	}

	public void testTimezoneFormatAnt() {
		String a = "Antarctica/McMurdo";
		String b = "Antarctica/South_Pole";

		assertTrue(test(a));
		assertTrue(test(b));
	}

	@Test
	public void testTimezoneFormatArc() {
		String a = "Arctic/Longyearbyen";

		assertTrue(test(a));
	}

	@Test
	public void testTimezoneFormatAsia() {
		String a = "Asia/Pyongyang";
		String b = "Asia/Tel_Aviv";
		String c = "Asia/Riyadh87";
		String d = "Asia/Ho_Chi_Minh";

		assertTrue(test(a));
		assertTrue(test(b));
		assertTrue(test(c));
		assertTrue(test(d));
	}

	@Test
	public void testTimezoneFormatAtlantic() {
		String a = "Atlantic/Reykjavik";
		String b = "Atlantic/Cape_Verde";

		assertTrue(test(a));
		assertTrue(test(b));
	}

	@Test
	public void testTimezoneFormatAus() {
		String a = "Australia/Victoria";
		String b = "Australia/Broken_Hill";

		assertTrue(test(a));
		assertTrue(test(b));
	}

	@Test
	public void testTimezoneFormatBrazil() {
		String a = "Brazil/Acre";

		assertTrue(test(a));
	}

	@Test
	public void testTimezoneFormatCanada() {
		String a = "Canada/Yukon";
		String b = "Canada/East-Saskatchewan";

		assertTrue(test(a));
		assertTrue(test(b));
	}

	@Test
	public void testTimezoneFormatChile() {
		String a = "Chile/EasterIsland";

		assertTrue(test(a));
	}

	@Test
	public void testTimezoneFormatEtc() {
		String a = "Etc/GMT+11";
		String b = "Etc/GMT";
		String c = "Etc/GMT0";
		String d = "Etc/Greenwich";
		String e = "Etc/UCT";
		String f = "Etc/UTC";
		String g = "Etc/Universal";
		String h = "Etc/Zulu";
		String i = "Etc/GMT-13";

		assertTrue(test(a));
		assertTrue(test(b));
		assertTrue(test(c));
		assertTrue(test(d));
		assertTrue(test(e));
		assertTrue(test(f));
		assertTrue(test(g));
		assertTrue(test(h));
		assertTrue(test(i));
	}

	@Test
	public void testTimezoneFormatEurope() {
		String a = "Europe/Moscow";
		String b = "Europe/Isle_of_Man";
		String c = "Europe/San_Marino";

		assertTrue(test(a));
		assertTrue(test(b));
		assertTrue(test(c));
	}

	@Test
	public void testTimezoneFormatIndia() {
		String a = "Indian/Mauritius";

		assertTrue(test(a));
	}

	@Test
	public void testTimezoneFormatMexico() {
		String a = "Mexico/General";

		assertTrue(test(a));
	}

	@Test
	public void testTimezoneFormatMiddleEast() {
		String a = "Mideast/Riyadh89";

		assertTrue(test(a));
	}

	@Test
	public void testTimezoneFormatPacific() {
		String s = "Pacific/Midway";
		Timezone t = new Timezone(s);
		assertEquals(t.toString(), s.toLowerCase());
	}

	@Test
	public void testTimezoneFormatSystem() {
		String a = "SystemV/HST10";
		String b = "SystemV/YST9YDT";

		assertTrue(test(a));
		assertTrue(test(b));
	}

	@Test
	public void testTimezoneFormatUS() {
		String a = "US/Eastern";
		String b = "US/East-Indiana";

		assertTrue(test(a));
		assertTrue(test(b));
	}

	@Test
	public void testTimezoneMisc() {
		String a = "HST";
		String b = "GB";
		String c = "GB-Eire";
		String d = "GMT0";
		String e = "CST6CDT";
		String f = "Greenwich";

		assertTrue(test(a));
		assertTrue(test(b));
		assertTrue(test(c));
		assertTrue(test(d));
		assertTrue(test(e));
		assertTrue(test(f));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTimezoneError1() {
		String a = "US-India";
		assertTrue(!test(a));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTimezoneError2() {
		String b = "US/fakeCountry";
		assertTrue(!test(b));
	}

	@Test
	public void testTimezoneError3() {
		String c = "US/";
		assertTrue(test(c));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTimezoneError4() {
		String d = "";
		assertTrue(!test(d));
	}

	@Test
	public void testTimezoneError5() {
		String d = "US/Eastern[][[";
		assertTrue(!test(d));
	}
}
