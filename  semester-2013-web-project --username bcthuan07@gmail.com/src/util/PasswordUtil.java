/**
 * 
 */
package util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * @author Thuan
 * 
 */
public class PasswordUtil {

	public static boolean authenticate(String attemptedPassword,
			byte[] encryptedPassword, byte[] salt) {
		// encrypt the clear-text password using the same salt that was used to
		// encrypt the original password
		byte[] encryptAttemptedPassword = new byte[0];
		encryptAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);

		return Arrays.equals(encryptAttemptedPassword, encryptedPassword);
	}

	public static byte[] getEncryptedPassword(String password, byte[] salt) {
		// PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST
		// specifically names SHA-1 as an acceptabble hashing algorithm for
		// PBKDF2
		String algorithm = "PBKDF2WithHmacSHA1";
		// SHA-1 generates 160 bit hashes, so that's what makes wsense here
		int derivedKeyLength = 160;
		// pick an iteration count that works for you. The NIST recommend at
		// least 1000 iterations:
		int iterations = 20000;
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations,
				derivedKeyLength);
		SecretKeyFactory f;
		try {
			f = SecretKeyFactory.getInstance(algorithm);
			return f.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static byte[] generateSalt() throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		return salt;
	}
}
