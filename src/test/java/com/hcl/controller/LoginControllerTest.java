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

import com.hcl.dto.LoginReqDto;
import com.hcl.dto.LoginResDto;
import com.hcl.service.LoginService;
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest {

	@Mock
	private LoginService loginService;
	
	@InjectMocks
	private LoginController loginController;
	
	@Test
	public void loginTest() {
		LoginReqDto req=new LoginReqDto();
		req.setEmail("Pradeep@gmail.com");
		req.setPassword("PER6P");
		LoginResDto res=new LoginResDto();
		res.setMessage("Login");
		res.setStatusCode(HttpStatus.OK.value());
		ResponseEntity<LoginResDto> expRes=new ResponseEntity<>(res, HttpStatus.OK);
		Mockito.when(loginService.login(req)).thenReturn(res);
		ResponseEntity<LoginResDto> actRes=loginController.login(req);
		assertEquals(expRes, actRes);
		
		
	}

}
