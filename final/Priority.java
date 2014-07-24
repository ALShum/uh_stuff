public class Priority {
	int priority;
	
	public Priority() {
		priority = 0;
	}
	
	public Priority(int priority) throws IllegalArgumentException {
		if(priority < 0 || priority > 9) throw new IllegalArgumentException("Invalid priority value");
		this.priority = priority;
	}
	
	public Priority(String priority) throws IllegalArgumentException {
		priority = priority.replaceAll("[^0-9]+", "");
		this.priority = Integer.valueOf(priority);
		if(this.priority < 0 || this.priority > 9) throw new IllegalArgumentException("Invalid priority value");
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
