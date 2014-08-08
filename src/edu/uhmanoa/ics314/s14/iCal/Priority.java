package edu.uhmanoa.ics314.s14.iCal;

/**
 * Priority class handles converting priority level from UI to valid iCalendar specifications.
 * Specifies the Priority level of an event and is used as part of the Event class.
 * 
 * Supports multiple input formats from the UI: string or integer.
 * Converts UI input to valid string for iCalendar specification of event priority level.
 * The priority level can range from 0 to 9.  
 * 0 is undefined and higher priority are lower numbers.
 * 
 * Also supports priority levels: High:1-4, medium:5, low:6-9.
 * 
 * @author Alex Shum
 */
public class Priority {
	int priority;

	/**
	 * Default constructor sets priority to 0.
	 */
	public Priority() {
		this.priority = 0;
	}

	/**
	 * Integer constructor for priority level.
	 * @param priority The priority level.
	 * @throws IllegalArgumentException if priority is not between 1-9.
	 */
	public Priority(int priority) throws IllegalArgumentException {
		if(priority < 0 || priority > 9) throw new IllegalArgumentException("Invalid priority value");
		this.priority = priority;
	}

	/**
	 * String constructor for priority level.  Automatically processes away non-integer characters.
	 * @param priority String of priority level.
	 * @throws IllegalArgumentException if priority is not between 1-9.
	 */
	public Priority(String priority) throws IllegalArgumentException {
		priority = priority.replaceAll("[^0-9-]+", "");
		int int_priority = Integer.valueOf(priority);

		if(int_priority < 0 || int_priority > 9) throw new IllegalArgumentException("Invalid priority value");
		else this.priority = int_priority;
	}
	
	/**
	 * Returns string representation of priority level to be used in Event class.
	 * @return String of priority level
	 */
	@Override
	public String toString() {
		return(Integer.toString(priority));
	}

	/**
	 * Returns a priority level as a string.
	 * @return String of priority level -- "High":1-4, "medium":5, "low":6-9.
	 */
	public String priorityLevel() {
		if(priority <= 4 && priority > 0) return("HIGH");
		else if(priority == 5) return("MEDIUM");
		else if(priority > 5) return("LOW");
		else throw new IllegalArgumentException("Priority 0 specifies an undefined priority level"); 
	}
}
