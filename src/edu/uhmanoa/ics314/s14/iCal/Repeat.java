package edu.uhmanoa.ics314.s14.iCal;

import java.util.Arrays;

/**
 * The Repeat class handles converting event repetition rules from UI to valid repetition rules for iCalendar specifications.
 * Repeat class is used to specify how frequent (daily, weekly, etc.) an event occurs and how many times it repeats.
 * 
 * Supports multiple inputs formats from UI:
 * 1. Frequency only.
 * 2. Frequency and count.
 * 3. Frequency, interval, and count.
 * 4. Frequency, interval, count and day of week.
 * 
 * Frequency: How often an event occurs, either every second, minute, hour, day, week, month or year.
 * Count: How many times an event repeats: if not specified the event repeats indefinitely.
 * Interval: A positive integer representing at which intervals the event repeats.  
 * 			 If frequency is daily and interval is 7, then the event repeats once every 7 days.
 * Day of week: A list of valid days: Sunday thru monday.  
 * 				If not specified this class will assume Monday to Friday.
 * 
 * 
 * Modified by Katrina Schenk
 */
public class Repeat {
	//private Freq f;
	public String f = "Every Weekday (Monday to Friday)";
	private int interval = -1;
	public String count = "0";
	private Day[] d = new Day[]{Day.MO, Day.TU, Day.WE, Day.TH, Day.FR};
   
   
        public Repeat(){ }
	
	/**
	 * Set the event recurrence rule.
	 * Valid recurrence rules: SECONDLY, MINUTELY, HOURLY, DAILY, WEEKLY, MONTHLY, YEARLY
	 * 
	 * @param f The event recurrence rule as a Repeat.Freq enum type.
	 */
	public Repeat(String f) {
		this.f = f;
	}
	
	/**
	 * Sets the event recurrence rule and total number of times the event repeats.
	 * Valid recurrence rules: SECONDLY, MINUTELY, HOURLY, DAILY, WEEKLY, MONTHLY, YEARLY
	 * 
	 * @param f The event recurrence rule as a Repeat.Freq enum type.
	 * @param count Total number of times event repeats.
	 * @throws IllegalArgumentException If count is less than 0.
	 */
	public Repeat(String f, String count) throws IllegalArgumentException {
          if(Integer.parseInt(count) < 0) {
             throw new IllegalArgumentException("This is not a valid count");
          } else {
		this.f = f;
		this.count = count;
          }
	}
	
	/**
	 * Sets the event recurrence rule, event intervals and total number of times the event repeats.
	 * Valid recurrence rules: SECONDLY, MINUTELY, HOURLY, DAILY, WEEKLY, MONTHLY, YEARLY
	 * 
	 * @param f The event recurrence rule as a Repeat.Freq enum type.
	 * @param interval Integer representing at which intervals the event repeats. 
	 *                 If frequency is daily and interval is 7, then the event repeats once every 7 days.
	 * @param count Total number of times event repeats.
	 * @throws IllegalArgumentException If interval or count is less than 0.		 
	 */
	public Repeat(String f, int interval, String count) throws IllegalArgumentException {
		if(Integer.parseInt(count) < 0) throw new IllegalArgumentException("This is not a valid count");
		if(interval < 0) throw new IllegalArgumentException("This is not a valid interval");
		
		this.f = f;
		this.interval = interval;
		this.count = count;
	}
	
	/**
	 * Sets the event recurrence rule, event intervals, total number of times the event repeats and days of the week.
	 * Valid recurrence rules: SECONDLY, MINUTELY, HOURLY, DAILY, WEEKLY, MONTHLY, YEARLY
	 * Valid days of the week: SU, MO, TU, WE, TH, FR, SA
	 * 
	 * @param f The event recurrence rule as a Repeat.Freq enum type.
	 * @param interval Integer representing at which intervals the event repeats. 
	 *                 If frequency is daily and interval is 7, then the event repeats once every 7 days.
	 * @param count Total number of times event repeats.
	 * @param d An array of Repeat.Day enum objects of the days of the week.
	 * @throws IllegalArgumentException If interval or count is less than 0.  Or if days of week incorrectly formatted.
	 */
	public Repeat(String f, int interval, String count, Day[] d) throws IllegalArgumentException {
		if(Integer.parseInt(count) < 0) throw new IllegalArgumentException("This is not a valid count");
		if(interval < 0) throw new IllegalArgumentException("This is not a valid interval");
		if(d.length > 7) throw new IllegalArgumentException("Too many days of the week!");
		
		this.f = f;
		this.interval = interval;
		this.count = count;
		this.d = d;
	}
	
	/** 
         * This property creates a string of data for the repeating function
	 * @return string
	 */
	public String getString() {
		String freq = "";
                if(f.contains("Every Weekday (Monday to Friday)")){
                	freq = "WEEKLY";
                } else {
                	freq = f;
                }
                
                String byTitle = "";
                if(f.equals("MONTHLY")){
                //	byTitle = "BYMONTHDAY";
                }
                if(freq.equals("WEEKLY")){
                	byTitle = ";BYDAY=";
                }
                String byContent = "";
                if(f.contains("Every Weekday (Monday to Friday)")){
                	byContent = "MO,TU,WE,TH,FR";
                }
               
                String toReturn = "FREQ=" + freq + ";" + "COUNT=" + count + byTitle + byContent;
		return(toReturn);
	}

	/**
	 * Used to represent valid frequency rules for recurring events.
	 * @author Alex Shum
	 */
	public static enum Freq {
		SECONDLY, MINUTELY,
		HOURLY, DAILY,
		WEEKLY, MONTHLY,
		YEARLY
	}
	
	/**
	 * Used to represent days of the week:
	 * SU - Sunday
	 * MO - Monday
	 * TU - Tuesday
	 * WE - Wednesday
	 * TH - Thursday
	 * FR - Friday
	 * SA - Saturday
	 * @author Alex Shum
	 */
	public static enum Day {
		SU, MO, TU, WE, TH, FR, SA
	}
}
