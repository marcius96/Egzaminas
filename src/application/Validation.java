package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	private static final String VALID_VIN_REGEX ="^[0-9]{1,5}%";
	private static final String VALID_EMAIL_ADDRESS_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$";
	
	
	
	public static boolean isValidVIN(String VIN) {
	Pattern VINPattern = Pattern.compile(VALID_VIN_REGEX);
	Matcher VINMatcher = VINPattern.matcher(VIN);
	return VINMatcher.find();

}
	public static boolean isValidEmail(String email){
		Pattern emailPattern = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX);
		Matcher emailMatcher = emailPattern.matcher(email);
		return emailMatcher.find();
	}
	
}
