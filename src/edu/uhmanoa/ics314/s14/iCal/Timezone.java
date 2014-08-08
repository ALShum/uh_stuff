package edu.uhmanoa.ics314.s14.iCal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

/**
 * The Timezone class handles converting timezones from UI to valid timezones for iCalendar specifications.
 * The Timezone is used to specify which timezone the event takes place in.
 * This is used as part of the Event class to define the event time zone.
 * 
 * Takes a user string for timezone from the following formats: 
 * 1. region/subregion - a valid region and subregion separated by "/".
 * 2. GMT+0 - a valid GMT offset which ranges from -12 to +14.
 * 
 * This class will automatically check for valid GMT offsets and valid regions and subregions.
 * Invalid GMT offset or region will result in an exception.
 * 
 * @warning Except for the default constructor, all timezones processed by this class will be strictly lowercase.
 * @author Alex Shum
 */

public class Timezone {
	String region;
	String subregion;

	/**
	 * Default constructor sets timezone to Pacific/Honolulu
	 */
	public Timezone() {
		region = "Pacific";
		subregion = "Honolulu";
	}

	/**
	 * Processes the Evene Timezone.
	 * @param tz Timezone as a string.  Either as GMT offset: ex. GMT+0 or region/subregion: ex. Pacific/Honolulu.
	 * @throws IllegalArgumentException If string does not follow above format or an invalid GMT offset or region/subregion.
	 */
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

	/**
	 * Prints the Timezone element for events as required by iCalendar specifications.
	 * @return Timezone as a string formatted to iCalendar specifications.
	 */
	@Override
	public String toString() {
		return((subregion == "") ? region : region + "/" + subregion);
	}
}
