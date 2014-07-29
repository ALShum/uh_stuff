package edu.uhmanoa.ics314.s14.iCal;

public class EventEntry {
	
	private String description;
	private String version;
	private String classification;
	private String geoPosition;
	private String priority;
	private String summary;
	private String dtStart;
	private String dtEnd;
	private String timeZone;
	
	/**
	* Sets the values of the data stored in the event.
	* @param  version that will overwrite the current version stored.
	* @param  classification that will overwrite the current version stored.
	* @param  geoPosition that will overwrite the current geoPosition stored.
	* @param  priority that will overwrite the current priority stored.
	* @param  summary that will overwrite the current summary stored.
	* @param  dtStart that will overwrite the current dtStart stored.
	* @param  dtEnd that will overwrite the current dtEnd stored.
	* @param  timeZone that will overwrite the current timeZone stored.
	*/
    public EventEntry(String description, String version, String classification, String geoPosition, String priority, String summary, 
    		String dtStart, String dtEnd, String timeZone){
    	this.description = description;
        this.version = version;
        this.classification = classification;
        this.geoPosition = geoPosition;
        this.priority = priority;
        this.summary = summary;
        this.dtStart = dtStart;
        this.dtEnd = dtEnd;
        this.timeZone = timeZone;
    }
    
    public EventEntry(){
    	description = null;
    	version = null;
    	classification = null;
    	geoPosition = null;
    	priority = null;
    	summary = null;
    	dtStart = null;
    	dtEnd = null;
    	timeZone = null;
    }

    /**
 	* Returns the current value of the object that is stored under the requested value in the event.
 	*
 	* @return The data currently stored under the requested value.  
 	*/
    
 	public String getVersion() {
 		
 		return version;
 	}

 	public String getClassification() {
 	 		
 	 	return classification;
 	}
 
 	public String getGeoPosition() {
 	 		
 	 	return geoPosition;
 	}

 	public String getPriority() {
 	 		
 	 	return priority;
 	}
 	
 	public String getSummary() {
 	 		
 	 	return summary;
 	}

 	public String getDTStart() {
 	 		
 	 	return dtStart;
 	}
 	
 	public String getDTEnd() {
 	 		
 	 	return dtEnd;
 	}

 	public String getTimeZone() {
 	 		
 	 	return timeZone;
 	}
 	
	/**
	* Changes the current value to the argument's value.
	* @param  value that will overwrite the current value stored.
	* @return  value The previous value stored which has been replaced.  
	*/
 	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public void setGeoPosition(String geoPosition) {
		this.geoPosition = geoPosition;
	}
 	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public void setDTStart(String dtStart) {
		this.dtStart = dtStart;
	}
	
	public void setDTEnd(String dtEnd) {
		this.dtEnd = dtEnd;
	}
	
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
}
