package edu.uhmanoa.ics314.s14.iCal;

public class tester {
	public static void main(String[] args) {
		String t = "-1";
		t = t.replaceAll("[^0-9-]+", "");
		System.out.println(t);
	}
}
