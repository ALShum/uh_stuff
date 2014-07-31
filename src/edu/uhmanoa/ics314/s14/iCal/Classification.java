package edu.uhmanoa.ics314.s14.iCal;

 

public class Classification {
	
	//Instance variable (which holds the classification)
	private String classification;
	
	
	//Method
	public Classification(String uiClassification) throws Exception {
		
		switch(uiClassification) {
	    
	    
		case "public":
			classification = "PUBLIC";
	    break;
		case "Public":
			classification = "PUBLIC";
	    break;
		case "PUBLIC":
			classification = "PUBLIC";
	    break;
		case "private":
			classification = "PRIVATE";
	    break;
		case "Private":
			classification = "PRIVATE";
	    break;
		case "PRIVATE":
			classification = "PRIVATE";
	    break;
		case "confidential":
			classification = "CONFIDENTIAL";
	    break;
		case "Confidential":
			classification = "CONFIDENTIAL";
	    break;
		case "CONFIDENTIAL":
			classification = "CONFIDENTIAL";
	    break;
	    default:
	    	throw new Exception("Classification not recognized.");
	
	
	}
		
	
	}
	//Method that returns the classification 
	public String retClassification()  
	
	{return classification;}




}
