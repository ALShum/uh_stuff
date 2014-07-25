package edu.uhmanoa.ics314.s14.iCal;

public class Priority {
	int priority;
	
	public Priority() {
		this.priority = 0;
	}
	
	public Priority(int priority) throws IllegalArgumentException {
		if(priority < 0 || priority > 9) throw new IllegalArgumentException("Invalid priority value");
		this.priority = priority;
	}
	
	public Priority(String priority) throws IllegalArgumentException {
		priority = priority.replaceAll("[^0-9-]+", "");
		int int_priority = Integer.valueOf(priority);
		
		if(int_priority < 0 || int_priority > 9) throw new IllegalArgumentException("Invalid priority value");
		else this.priority = int_priority;
	}
	
	@Override
	public String toString() {
		return(Integer.toString(priority));
	}
	
	public String priorityLevel() {
		if(priority <= 4 && priority > 0) return("HIGH");
		else if(priority == 5) return("MEDIUM");
		else return("LOW");
	}
}
