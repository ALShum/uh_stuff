package edu.uhmanoa.ics314.s14.iCal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

public class Timezone {
	String region;
	String subregion;
	
	//default timezone
	public Timezone() {
		region = "Pacific";
		subregion = "Honolulu";
	}
	
	//string to process
	public Timezone(String tz) throws IllegalArgumentException {
		int slashPos = (tz.indexOf("/") < 0) ? tz.length() : tz.indexOf("/");
		String region = tz.substring(0, slashPos).replaceAll("[^a-zA-Z0-9-+]+", "").trim().toLowerCase();
		String subregion =  (tz.indexOf("/") < 0) ? "" : tz.substring(slashPos + 1, tz.length()).replaceAll("[^a-zA-Z0-9-+/_]+", "").trim().toLowerCase();
		
		List<String> validTZ = Arrays.asList(TimeZone.getAvailableIDs());
		List<String> validRegions = new ArrayList<String>();
		List<String> validSubregions = new ArrayList<String>();
		for(String s : validTZ) {
			s = s.toLowerCase().trim();
			if(s.contains("/")) {
				validRegions.add(s.substring(0, s.indexOf("/")));
				validSubregions.add(s.substring(s.indexOf("/") + 1, s.length()));
			} else {
				validRegions.add(s);
				validSubregions.add("");
			}
		}
		
		if(validRegions.contains(region)) {
			this.region = region;
		} else {
			throw new IllegalArgumentException("Invalid region");
		}
		
		if(validSubregions.contains(subregion)) {
			this.subregion = subregion;
		} else {
			throw new IllegalArgumentException("Invalid subregion");
		}
	}
	
	@Override
	public String toString() {
		return((subregion == "") ? region : region + "/" + subregion);
	}
}
