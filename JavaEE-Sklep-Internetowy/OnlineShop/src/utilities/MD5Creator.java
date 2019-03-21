package utilities;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Creator {
	
	private MD5Creator() {
		
	}
	

	public static String getMD5(String input) {
		MessageDigest md5;
		
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		md5.update(input.getBytes());
		BigInteger hash = new BigInteger(1, md5.digest());
		String result = hash.toString(16);
		
		if (result.length() == 31)
			result = "0" + result;
		return result;
	}
}
