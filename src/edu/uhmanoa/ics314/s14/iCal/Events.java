package edu.uhmanoa.ics314.s14.iCal;

public class Events {
	private String version;
	private String classification;
	private String geoPosition;
	private String priority;
	private String summary;
	private String dtStart;
	private String dtEnd;
	private String timeZone;

	public Events() {
		version = "2.0"; //set version
		classification = null;
		geoPosition = null;
		priority = null;
		summary = null;
		dtStart = null;
		dtEnd = null;
		timeZone = null;
	}

	/** 
	 * This property defines the access classification for a
	 * calendar component.
	 *	    
	 * @return The classification value
	 */
	public boolean eClassification(String classification) {	
		try {
			Classification c = new Classification(classification);
			this.classification = c.toString();
			return(true);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
			return(false);
		}
	}

	/** 
	 * This property specifies information related to the global
	 * position for the activity specified by a calendar component.
	 *	    
	 * @return The geoPosition  
	 */
	public boolean eGeoPosition(String geoPosition) {  
		try {
			GeoPosition g = new GeoPosition(geoPosition);
			this.geoPosition = g.toString();
			return(true);
		} catch (IllegalArgumentException e){
			System.out.println(e); 
			return(false);
		}    
	}   

	/** 
	 *  This property defines the relative priority for a calendar
	 * component.
	 *	    
	 * @return The priority value  
	 */
	public boolean ePriority(String uiPriority) {
		try {
			Priority p = new Priority(uiPriority);
			priority = p.toString();
			return(true);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
			return(false);
		} 
	}	

	/** 
	 *  This property defines a short summary or subject for the
	 * calendar component.
	 *	    
	 * @return The summary value  
	 */
	public boolean eSummary(String uiSummary) {
		summary = uiSummary;
		return(true);
	}	

	/** 
	 *  This property defines a short summary or subject for the
	 * calendar component.
	 *	    
	 * @return The dtStart value  
	 */
	public boolean eDTStart(String uiDTS) {
		try {
			DateTime start = new DateTime(uiDTS);
			dtStart = start.toString();
			return(true);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
			return(false);
		}
	}

	/** 
	 *  This property specifies the date and time that a calendar
	 *  component ends.
	 *	    
	 * @return The dtEnd value  
	 */
	public boolean eDTEnd(String uiDTE) {		
		try {
			DateTime end = new DateTime(uiDTE);
			dtEnd = end.toString();
			return(true);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
			return(false);
		}
	}

	/** 
	 *  This property specifies the text value that uniquely
	 *  identifies the "VTIMEZONE" calendar component in the scope of an
	 *  iCalendar object.
	 *	    
	 * @return The timeZone value  
	 */
	public boolean eTimeZone(String uiTimeZone) {
		try {
			Timezone tz = new Timezone(uiTimeZone);
			timeZone = tz.toString();
			return(true);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
			return(false);
		}
	}
	
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

}