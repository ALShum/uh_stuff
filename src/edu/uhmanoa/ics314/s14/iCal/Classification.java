package edu.uhmanoa.ics314.s14.iCal;


/**
 * This class validates the user input for Classification and returns a string that is in accordance with RFC 5545 upon successful validation.
 * @author Tamotu Ngauamo
 */
public class Classification {
	
        //Instance variable (which holds the classification)
        private String classification;
        
        
        /**
         * This constructor uses if and switch statements to verify that the user input is a string that equals "PUBLIC", "PRIVATE", or "CONFIDENTIAL".
         * @default When the user types in a string of letters that doesn't equal any of the valid 3, then classification will be set to the default, "PUBLIC".  This feature complies with section 3.8.1.3 of the RFC 5545 specification.
         * @param  uiClassification         the user input for Classification.
         * @throws IllegalArgumentException if classification has numbers in the string.
         */
        
        
        public Classification(String uiClassification) throws IllegalArgumentException {
        		
        	
        	if (uiClassification.matches("[a-zA-Z]+")){
        		 	
						switch(uiClassification.toUpperCase()) {


						case "PUBLIC":
                        classification = "PUBLIC";
                        break;

						case "PRIVATE":
                        classification = "PRIVATE";
                        break;

						case "CONFIDENTIAL":
                        classification = "CONFIDENTIAL";
                        break;
						default:
                        classification = "PUBLIC";
                		}
				
                 
                }
        	//Throw inputs that have numbers or special characters.
        	else {
        		throw new IllegalArgumentException("Classification not recognized.");
        		}


        }
        /**
         *  @return valid string input from the user in the format per section 3.8.1.3 of RFC 5545.
         */
        @Override
        public String toString() {
                return(classification);
        }
}