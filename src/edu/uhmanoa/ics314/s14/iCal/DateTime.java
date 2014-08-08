package edu.uhmanoa.ics314.s14.iCal;

import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * DateTime class handles converting dates and times from UI to valid dates for iCalendar specifications.
 * DateTime is used to specify the date and time for event start and event end. 
 * This is used as part of the Event class to define event time periods.
 * 
 * Supports multiple input formats from the UI: 
 * 1. String: YYYYMMDDTHHmmss, YYYYMMDDTHHmm, YYYYMMDDTHH, YYYYMMDD
 * Y = year
 * M = month
 * D = day
 * 'T' = required separator character
 * HH = hour (in 24-hour time)
 * mm = minute
 * ss = second
 * 
 * 2. Java Calendar Object from java.util.calendar.
 * 
 * 3. integers for year/month/day/hour/minute/second.
 *
 * Automatically supports leap years.  In valid dates are accepted and automatically processed:
 * January 32 will be parsed as February 1.  June -1 will be parsed as May 31.
 * 
 * Year, Month, Day must be specified.  Hour, minute, second can be specified:
 * Minute cannot be specified without hour and second cannot be specified without hour and minute.
 * If any or all of second/minute/hour is not specified it will be automatically set to 0.
 * 
 * @Note String format only supports a very limited number of date/time formats.
 * 
 * @author Alex Shum
 */
public class DateTime {
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
	Calendar date;

	/**
	 * Empty constructor sets the date/time to the current date at 0:00:00 time.
	 */
	public DateTime() {
		date = Calendar.getInstance();
		date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), 0, 0, 0);
	}

	/**
	 * Sets date and time based on java.util.calendar object.
	 * @param date Java Calendar Object.
	 */
	public DateTime(Calendar date) {
		date.set(date.get(Calendar.YEAR),
				date.get(Calendar.MONTH) - 1, 
				date.get(Calendar.DATE), 
				date.get(Calendar.HOUR), 
				date.get(Calendar.MINUTE), 
				date.get(Calendar.SECOND));
		this.date = date;
	}

	/**
	 * Sets date from user input.  Time is automatically set to 0:00:00.
	 * @param year The year as integer.
	 * @param month The month as integer.
	 * @param day The day as integer.
	 */
	public DateTime(int year, int month, int day) {
		date = Calendar.getInstance();
		date.set(year, month - 1, day, 0, 0, 0);
	}

	/**
	 * Sets date/time from user input.  Minute/seconds automatically set to 00:00.
	 * @param year The year as integer.
	 * @param month The month as integer.
	 * @param day The day as integer.
	 * @param hour The hour as integer.
	 */
	public DateTime(int year, int month, int day, int hour) {
		date = Calendar.getInstance();
		date.set(year, month - 1, day, hour, 0, 0);
	}

	/**
	 * Sets date/time from user input.  Seconds automatically set to 00.
	 * @param year The year as integer.
	 * @param month The month as integer.
	 * @param day The day as integer.
	 * @param hour The hour as integer.
	 * @param minute The minute as integer.
	 */
	public DateTime(int year, int month, int day, int hour, int minute) {
		date = Calendar.getInstance();
		date.set(year, month - 1, day, hour, minute, 0);
	}

	/**
	 * Sets date/time from user input.
	 * @param year The year as integer.
	 * @param month The month as integer.
	 * @param day The day as integer.
	 * @param hour The hour as integer.
	 * @param minute The minute as integer.
	 * @param second The second as integer.
	 */
	public DateTime(int year, int month, int day, int hour, int minute, int second) {
		date = Calendar.getInstance();
		date.set(year, month - 1, day, hour, minute, second);
	}

	//http://stackoverflow.com/questions/3389348/parse-any-date-in-java
	//todo see if we can borrow code
	/**
	 * Sets date/time processed as a string with the follow formats:
	 * 
	 * YYYYMMDDTHHmmss, YYYYMMDDTHHmm, YYYYMMDDTHH, YYYYMMDD
	 * Y = year
	 * M = month
	 * D = day
	 * 'T' = required separator character
	 * HH = hour (in 24-hour time)
	 * mm = minute
	 * ss = second
	 * 
	 * 
	 * Common date/time strings such as: MM/DD/YYYY or DD/MM/YYYY will not be accepted.
	 * @warning NO OTHER FORMATS WILL BE ACCEPTED EXCEPT THOSE LISTED ABOVE.
	 * 
	 * @param t date/time string with above formatting.
	 * @throws IllegalArgumentException If string does not follow one of the four documented string formats.
	 */
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

	/**
	 * Prints the date/time element for start/end of events required for iCalendar specifications.
	 * @return Date/time as a string formatted to iCalendar specifications.
	 */
	@Override
	public String toString() {
		return(df.format(date.getTime()));
	}
}
