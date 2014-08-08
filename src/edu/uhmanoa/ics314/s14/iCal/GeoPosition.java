package edu.uhmanoa.ics314.s14.iCal;

/**
 * 
 * @author Tamotu Ngauamo
 */
public class GeoPosition {

	public String geoPosition;
	private float gPositionLat;
	private float gPositionLong;

	public GeoPosition() {
		//TODO
	}
	
	public GeoPosition(String uiGeoPos) throws IllegalArgumentException {
     int length = uiGeoPos.length();
    if (length <= 0)	{
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
		if (gPositionLat > 90.000000 && gPositionLat < -90.000000) {
			throw new IllegalArgumentException("Invalid Latitiude");
		}

		//Setting the valid range of the Longitude input.
		if (gPositionLong < -180.000000 && gPositionLong > 180.000000) {
			throw new IllegalArgumentException("Invalid Longitude");
		}
	}
	
	public GeoPosition(float lat, float lon) throws IllegalArgumentException {
		//TODO
	}
	

	@Override
	public String toString() {
		return Float.toString(gPositionLat) + "," + Float.toString(gPositionLong);
	}

}
