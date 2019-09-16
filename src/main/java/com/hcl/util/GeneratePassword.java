package com.hcl.util;

import java.security.SecureRandom;

public class GeneratePassword {

	static SecureRandom secureRnd = new SecureRandom();
	public static String randomAlphaNumeric( String userName, String phone) {
			String randString = userName.substring(0, 4) + phone.substring(4, 8);
		 StringBuilder sb = new StringBuilder(randString.length());
		    for (int i = 0; i < randString.length(); i++)
		      sb.append(randString.charAt(secureRnd.nextInt(randString.length())));
		    return sb.toString().toUpperCase();

	}
}