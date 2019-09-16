package com.hcl.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.dto.LoginReqDto;
import com.hcl.dto.LoginResDto;
import com.hcl.entity.Student;
import com.hcl.exception.UserNotFoundException;
import com.hcl.repository.StudentRepository;
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginServiceImplTest {

	@Mock
	private StudentRepository studentRepository;
	
	@InjectMocks
	private LoginServiceImpl loginServiceImpl;
	
	@Test
	public void loginTest() {
		LoginReqDto req=new LoginReqDto();
		req.setEmail("Pradeep@gmail.com");
		req.setPassword("PER6P");
		LoginResDto res=new LoginResDto();
		res.setMessage("Login");
		res.setStatusCode(HttpStatus.OK.value());
		Student student=new Student();
		student.setStudentId(1);
		student.setEmail(req.getEmail());
		student.setPassword(req.getPassword());
		Mockito.when(studentRepository.findByEmailAndPassword(req.getEmail(),
				req.getPassword())).thenReturn(Optional.of(student));
		LoginResDto actRes=loginServiceImpl.login(req);
		assertEquals(res.getStatusCode(), actRes.getStatusCode());
		
	}
	

	@Test(expected = UserNotFoundException.class)
	public void userNotFoundTest() {
		LoginReqDto req=new LoginReqDto();
		req.setEmail("Pradeep@gmail.com");
		req.setPassword("PER6P");
	loginServiceImpl.login(req);
		
		
	}

}
