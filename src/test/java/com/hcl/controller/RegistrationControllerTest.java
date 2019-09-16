package com.hcl.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.dto.RegReqDto;
import com.hcl.dto.RegResDto;
import com.hcl.service.Registrationservice;
@RunWith(SpringJUnit4ClassRunner.class)
public class RegistrationControllerTest {
	
	@Mock
	private Registrationservice registrationService;
	
	@InjectMocks
	private RegistrationController registrationController;

	@Test
	public void registrationTest() {
		RegReqDto req=new RegReqDto();
		req.setEmail("Pradeep@gmail.com");
		req.setStudentName("Pradeep");
		RegResDto res=new RegResDto();
		res.setMessage("Registration");
		res.setStatusCode(HttpStatus.CREATED.value());
		ResponseEntity<RegResDto> expRes=new ResponseEntity<>(res,HttpStatus.CREATED);
		Mockito.when(registrationService.registration(req)).thenReturn(res);
		ResponseEntity<RegResDto> actRes=registrationController.registration(req);
		assertEquals(expRes, actRes);
	}

}
