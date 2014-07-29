package edu.uhmanoa.ics314.s14.iCal;

public class Events {
	public EventEntry event;
	
	public Events() {
		event = new EventEntry();
	}


	/** 
	* This property specifies the identifier corresponding to the
    * highest version number or the minimum and maximum range of the
    * iCalendar specification that is required in order to interpret the
    * iCalendar object.
	*	    
	* @return The version value  
	*/
	public boolean eVersion(String uiVersion) {
		event.setVersion("2.0");
		return true;
	}
	
	/** 
	* This property defines the access classification for a
    * calendar component.
	*	    
	* @return The classification value
	*/
	public boolean eClassification(String uiClass) {	
		event.setClassification("PUBLIC");
		return true;
	}	
	
	/** 
	* This property specifies information related to the global
    * position for the activity specified by a calendar component.
	*	    
	* @return The geoPosition  
	*/
	public boolean eGeoPosition(String uiGeoPos) {	
		event.setGeoPosition("University of Hawaii at Manoa, 2500 Campus Rd, Honolulu, HI, United States");
		return true;
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
			event.setPriority(p.toString());
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
		event.setSummary(uiSummary);
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
			event.setDTStart(start.toString());
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
			event.setDTEnd(end.toString());
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
			Timezone_old tz = new Timezone_old(uiTimeZone);
			event.setTimeZone(tz.toString());
			return(true);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
			return(false);
		}
	}
	
	
}
