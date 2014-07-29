package edu.uhmanoa.ics314.s14.iCal;

import java.util.Calendar;
import java.text.SimpleDateFormat;

//handles date-time start and date-time end
//todo: handle other date string formats
public class DateTime {
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
	Calendar date;
	
	//sets to 11:59:00 PM of today
	public DateTime() {
		date = Calendar.getInstance();
		date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), 23, 59, 0);
	}
	
	public DateTime(Calendar date) {
		this.date = date;
	}
	
	//defaults to noon
	public DateTime(int year, int month, int day) {
		date = Calendar.getInstance();
		date.set(year, month, day, 12, 0, 0);
	}
	
	public DateTime(int year, int month, int day, int hour) {
		date = Calendar.getInstance();
		date.set(year, month, day, hour, 0, 0);
	}
	
	public DateTime(int year, int month, int day, int hour, int minute) {
		date = Calendar.getInstance();
		date.set(year, month, day, hour, minute, 0);
	}
	
	public DateTime(int year, int month, int day, int hour, int minute, int second) {
		date = Calendar.getInstance();
		date.set(year, month, day, hour, minute, second);
	}
	
	//http://stackoverflow.com/questions/3389348/parse-any-date-in-java
	//todo see if we can borrow code
	public DateTime(String t) throws IllegalArgumentException {	
		int year = 0;
		int month = 0;
		int day = 0;
		int hour = 0;
		int minute = 0;
		int second = 0;
		
		//TODO
		//detects MM/DD/YYYY
		//Note: cannot distinguish DD/MM/YYYY, we'll force europeans to use MM/DD/YYYY
		//detects YYYY/MM/DD

		t = t.replaceAll("[^0-9tT]+", "").toLowerCase();
		if(t.contains("t") && t.length() == 15) { //detects YYYYMMDDTHHmmss
			year = Integer.valueOf(t.substring(0, 4));
			month = Integer.valueOf(t.substring(4, 6))-1;
			day = Integer.valueOf(t.substring(6, 8));
			hour = Integer.valueOf(t.substring(9, 11));
			minute = Integer.valueOf(t.substring(11, 13));
			second = Integer.valueOf(t.substring(13, 15));
		} else if(t.contains("t") && t.length() == 13) { //detects YYYYMMDDTHHmm
			year = Integer.valueOf(t.substring(0, 4));
			month = Integer.valueOf(t.substring(4, 6))-1;
			day = Integer.valueOf(t.substring(6, 8));
			hour = Integer.valueOf(t.substring(9, 11));
			minute = Integer.valueOf(t.substring(11, 13));
		} else if(t.contains("t") && t.length() == 11) { //detects YYYYMMDDTHH
			year = Integer.valueOf(t.substring(0, 4));
			month = Integer.valueOf(t.substring(4, 6))-1;
			day = Integer.valueOf(t.substring(6, 8));
			hour = Integer.valueOf(t.substring(9, 11));
		} else if(!t.contains("t") && t.length() == 8) { //detects YYYYMMDD
			year = Integer.valueOf(t.substring(0, 4));
			month = Integer.valueOf(t.substring(4, 6))-1;
			day = Integer.valueOf(t.substring(6, 8));
		} else {
			throw new IllegalArgumentException("Unknown date format");
		}
	
		date = Calendar.getInstance();
		date.set(year, month, day, hour, minute, second);
	}
	
	@Override
	public String toString() {
		return(df.format(date.getTime()));
	}
}
