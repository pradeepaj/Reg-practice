package com.hcl.util;

import org.springframework.http.HttpStatus;

public class TrainingConstants {

	public static final int CREATED =HttpStatus.CREATED.value();
	public static final int OK =HttpStatus.OK.value();
	public static final String REG_RESPONSE_MESSAGE="Registration Successfull";
	public static final String LOGIN_RESPONSE_MESSAGE="Login Successfull";
	public static final String LOGIN_EXCEPTION_RESPONSE_MESSAGE="Please Enter Valid Credentials";
}
