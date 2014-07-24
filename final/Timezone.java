import java.util.Arrays;

//Class that handles all timezones
//Possible todo list:
//add UTC offsets
//allow UI to enter in UTC offsets and automatically return valid region/subregion
//figure out what the donk a "globally unique time zone identifer is: see 3.8.3.1
//import java.util.TimeZone
//String[] TZ = TimeZone.getAvailableIDs(); for all valid ones
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
		tz = tz.toLowerCase().trim();
		
		if(tz.contains("/")){
			processTZ(tz);
		} else if(tz.contains("hawaii")   || 
				  tz.contains("alaska")   || 
				  tz.contains("pacific")  || 
				  tz.contains("mountain") || 
				  tz.contains("central")  ||
				  tz.contains("eastern")) {
			processUSTZ(tz);
		} else {
			throw new IllegalArgumentException("Time zone should be specified as: 'region/subregion'");
		}
	}
	
	@Override
	public String toString() {
		return(region + "/" + subregion);
	}
	
	private void processTZ(String tz) {
		int slashPos = tz.indexOf("/");
		String region = tz.substring(0, slashPos).replaceAll("[^a-zA-Z ]", "").trim();
		String subregion = tz.substring(slashPos + 1, tz.length()).replaceAll("[^a-zA-Z ]", "").trim();
		
		//check valid region
		if(!Arrays.asList("etc", "pacific", "america", "atlantic", "europe", "africa", "asia", "australia").contains(region)) {
			throw new IllegalArgumentException("Invalid timezone region");
		}
		//less stringent on subregion; there are too many
		//if(!"".contains(subregion)) throw new IllegalArgumentException("Invalid timezone subregion");
		
		this.region = region;
		this.subregion = subregion;
	}
	
	private void processUSTZ(String tz) {
		if(tz.contains("hawaii")) {
			region = "pacific";
			subregion = "honolulu";
		} else if(tz.contains("alaska")) {
			region = "america";
			subregion = "anchorage";
		} else if(tz.contains("pacific")) {
			region = "america";
			subregion = "los_angeles";
		} else if(tz.contains("mountain")) {
			region = "america";
			subregion = "denver";
		} else if(tz.contains("central")) {
			region = "america";
			subregion = "chicago";
		} else if(tz.contains("eastern")) {
			region = "america";
			subregion = "new_york";
		} else {
			throw new IllegalArgumentException("Invalid US timezone");
		}
	}
}
