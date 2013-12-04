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

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	private static Pattern pattern;
	private static Matcher matcher;

	public static boolean isEmail(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean isUsername(String username) {
		pattern = Pattern.compile(USER_NAME_PATTERN);
		matcher = pattern.matcher(username);
		return matcher.matches();
	}

	public static boolean isPassword(String password) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
