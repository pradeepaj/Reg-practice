package com.hcl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.LoginReqDto;
import com.hcl.dto.LoginResDto;
import com.hcl.service.LoginService;

/**
 * 
 * @author Pradeep AJ
 *
 */
@RestController
@RequestMapping("/itraining")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * Student Login 
	 * @param LoginReqDto
	 * @return LoginResDto
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginResDto> login(@RequestBody LoginReqDto reqDto){
		logger.info("Enter into LoginController login()");
		return new ResponseEntity<>(loginService.login(reqDto),HttpStatus.OK);
		
	}
	
}
