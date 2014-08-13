package edu.uhmanoa.ics314.s14.iCal;

/**
 * This class validates the user input for Geographic Position and returns a string that is in accordance with RFC 5545 upon successful validation.
 * @author Tamotu Ngauamo
 */
public class GeoPosition {
		
        public 	String geoPosition;
        private float gPositionLat;
        private float gPositionLong;


        /**
         * This constructor first checks that the user input is not a blank entry. 
         * After it passes the blank entry check, this constructor splits the user input for Latitude and Longitude at the semi-colon and stores the strings into an array.
         * The two strings are then stored into two new variables, geoPositionLat and geoPositionLong.
         * Two new variables (gPositionLat and gPositionLong) are created to store the float values of the geoPositionLat and geoPositionLong strings.
         * The variables are then checked that they are in the valid range values for latitude(-90 to +90) and longitude(-180 to +180).
         * If the user input string passes all checks, the valid string is returned.
         *   
         * @param  uiGeoPos          					the user input for their latitude and longitude.
         * @throws IllegalArgumentException 	 if the entry is blank (string's length is 0 or less).
         * @throws IllegalArgumentException		if the latitude is out of range.
         * @throws IllegalArgumentException		if the longitude is out of range.
         */
        
        public GeoPosition(String uiGeoPos) throws IllegalArgumentException {
        	
        		int length = uiGeoPos.length();
              //If statement that throws input strings that have a length of zero or less (blank entries).
        			if (length <= 0)    {
                       throw new IllegalArgumentException("Invalid Input.");
        			}
   
   
   
        			//Splitting the input string at the semicolon ";".
        			String[] geoPositionLatLong = uiGeoPos.split(";");
        			//Declaring and initializing geoPositionLat as the first of the two split strings (geoPositionLatLong[0]).
        			String geoPositionLat = geoPositionLatLong[0];
        			//Declaring and initializing geoPositionLong as the second of the two split strings (geoPositionLatLong[1]).
        			String geoPositionLong = geoPositionLatLong[1];
        			//Initializing gPositionLat as the float value of the geoPositionLat string.
        			gPositionLat = Float.valueOf(geoPositionLat);
        			//Initializing gPositionLong as the float value of the geoPositionLong string.
        			gPositionLong = Float.valueOf(geoPositionLong);


        			//Setting the valid range of the Latitude input.
        			if (gPositionLat > 90.000000 || gPositionLat < -90.000000) {
                        throw new IllegalArgumentException("Invalid Latitiude");
        			}

        			//Setting the valid range of the Longitude input.
        			if (gPositionLong < -180.000000 || gPositionLong > 180.000000) {
                        throw new IllegalArgumentException("Invalid Longitude");
        				}
        			}

        /**
         * @return valid string input from the user that has been modified from the format per section 3.8.1.6 of RFC 5545, with a comma "," instead of a semi-colon ";",to be able to work in Google Calendars. 
         */
        @Override
        public String toString() {
                return Float.toString(gPositionLat) + "," + Float.toString(gPositionLong);
        }

}