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

import com.hcl.dto.RegReqDto;
import com.hcl.dto.RegResDto;
import com.hcl.service.Registrationservice;

/**
 * 
 * @author Pradeep AJ
 *
 */

@RestController
@RequestMapping("/itraining")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class RegistrationController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	@Autowired
	private Registrationservice registrationservice;

	/**
	 * user Registration 
	 * @param RegReqDto
	 * @return RegResDto
	 */
	
	@PostMapping("/registration")
	public ResponseEntity<RegResDto> registration(@RequestBody RegReqDto reqDto){
		logger.info("Enter into RegistrationController registration()");
		return new ResponseEntity<>(registrationservice.registration(reqDto), HttpStatus.CREATED);
	}
	

}
