package edu.uhmanoa.ics314.s14.iCal;

public class GeoPosition {
	String geoPositionLat;
	String geoPositionLong;
	float gPositionLat = Float.parseFloat(geoPositionLat);
	float gPositionLong = Float.parseFloat(geoPositionLong);
	{
	//Figuring out if Latitude is above or below the Equator
	
	/*if (gPositionLat >= 0 && gPositionLat <= 90){
		System.out.println("Above the Equator" + "+");
		else if (gPositionLat < 0 && gPositionLat >= -90);
		System.out.println("Below the Equator" + "-");
	*/
	
	//Weeding out the bad Latitudes
	
	if (gPositionLat > 90.000000 && gPositionLat < -90.000000){
			System.out.println("Your Latitude input is invalid!!!!!!!!!!");
			else if (gPositionLat <= 90.000000 && gPositionLat >= -90.000000)
				System.out.println("Your Latitude is: " + gPositionLat + ".");
	}
	
	if (gPositionLong < -180.000000 && gPositionLong > 180.000000){
		System.out.println("Your Longitude input is invalid!!!!!!!!!!");
		else if (gPositionLong >= -180.000000 && gPositionLong <= 180.000000)
		System.out.println("Your Longitude input is: " + gPositionLong + ".");
	}
	
	if (gPositionLong >= 000.000000 && gPositionLong <= 180.000000){
		System.out.println("You're on the East of the Prime Meridian");
		else if (gPositionLong < 000.000000 && gPositionLong >= -180.00000)
		System.out.println("You're on the West of the Prime Meridian");
		else System.out.println("You're Lost.");
	}
	
	
	
	
	
	}
}
