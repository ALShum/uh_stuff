package edu.uhmanoa.ics314.s14.iCal;

public class tester {
	public static void main(String[] args) {
		String tz = "HST/";
		System.out.println(tz);
		Timezone t = new Timezone(tz);
		t.toString();
	}
}
