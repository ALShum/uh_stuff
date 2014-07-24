import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

public class tester {
	public static void main(String[] args) {
		List<String> validTZ = Arrays.asList(TimeZone.getAvailableIDs());
		
		for(String s : validTZ) {
			System.out.println(s);
		}
		
		String s = "1234567890-+qwedksjfl;g[]\';/.,  ";
		System.out.println(s.replaceAll("[^a-zA-Z0-9-+]+", ""));
	}
}
