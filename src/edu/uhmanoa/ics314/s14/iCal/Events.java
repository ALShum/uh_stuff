package edu.uhmanoa.ics314.s14.iCal;

public class Events {
	public EventEntry event;
	
	public Events() {
		event = new EventEntry(null, null, null, null, null, null, null, null);
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
	public boolean eVersion(String uiVersion){
		
		return false;
	}
	
	/** 
	* This property defines the access classification for a
    * calendar component.
	*	    
	* @return The classification value
	*/
	public String eClassification(String uiClass){	
	
		return null;
	}	
	
	/** 
	* This property specifies information related to the global
    * position for the activity specified by a calendar component.
	*	    
	* @return The geoPosition  
	*/
	public String eGeoPosition(String uiGeoPos){	
	
		return null;
	}	
	
	/** 
	*  This property defines the relative priority for a calendar
    * component.
	*	    
	* @return The priority value  
	*/
	public String ePriority(String uiPriority){	
		Priority p = new Priority(uiPriority);
		return(p.toString());
	}	
	
	/** 
	*  This property defines a short summary or subject for the
    * calendar component.
	*	    
	* @return The summary value  
	*/
	public String eSummary(String uiSummary){	
		return(uiSummary);
	}	
	
	/** 
	*  This property defines a short summary or subject for the
    * calendar component.
	*	    
	* @return The dtStart value  
	*/
	public String eDTStart(String uiDTS){
		DateTime start = new DateTime(uiDTS);
		return(start.toString());
	}
	
	/** 
	*  This property specifies the date and time that a calendar
    *  component ends.
	*	    
	* @return The dtEnd value  
	*/
	public String eDTEnd(String uiDTE){
		DateTime end = new DateTime(uiDTE);
		return end.toString();
	}
	
	/** 
	*  This property specifies the text value that uniquely
    *  identifies the "VTIMEZONE" calendar component in the scope of an
    *  iCalendar object.
	*	    
	* @return The timeZone value  
	*/
	public String eTimeZone(String uiTimeZone){
		Timezone_old tz = new Timezone_old(uiTimeZone);
		return(tz.toString());
	}
	
}
