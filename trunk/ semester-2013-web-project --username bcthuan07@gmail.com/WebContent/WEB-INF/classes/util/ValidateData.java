/**
 * 
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Thuan
 *
 */
public class ValidateData {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String USER_NAME_PATTERN = "^[a-z0-9_-]{3,15}$";
	
	public static boolean isEmail(String email){
		
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean isUsername(String username){
		Pattern pattern = Pattern.compile(USER_NAME_PATTERN);
		Matcher matcher = pattern.matcher(username);
		return matcher.matches();	}
}
