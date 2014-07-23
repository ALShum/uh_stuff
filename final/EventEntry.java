
public class EventEntry {
	
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
    public EventEntry(String version, String classification, String geoPosition, String priority, String summary, 
    		String dtStart, String dtEnd, String timeZone){
        this.version = version;
        this.classification = classification;
        this.geoPosition = geoPosition;
        this.priority = priority;
        this.summary = summary;
        this.dtStart = dtStart;
        this.dtEnd = dtEnd;
        this.timeZone = timeZone;
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
	
	public String setVersion(String version) {
		this.version = version;
		return version;
	}
	
	public String setClassification(String classification) {
		this.classification = classification;
		return classification;
	}
	
	public String setGeoPosition(String geoPosition) {
		this.geoPosition = geoPosition;
		return geoPosition;
	}
 	
	public String setPriority(String priority) {
		this.priority = priority;
		return priority;
	}
	
	public String setSummary(String summary) {
		this.summary = summary;
		return summary;
	}
	
	public String setDTStart(String dtStart) {
		this.dtStart = dtStart;
		return dtStart;
	}
	
	public String setDTEnd(String dtEnd) {
		this.dtEnd = dtEnd;
		return dtEnd;
	}
	
	public String setTimeZone(String timeZone) {
		this.timeZone = timeZone;
		return timeZone;
	}
	
}
