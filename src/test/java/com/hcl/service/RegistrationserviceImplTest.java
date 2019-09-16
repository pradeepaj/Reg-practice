package com.hcl.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.dto.RegReqDto;
import com.hcl.dto.RegResDto;
import com.hcl.entity.Student;
import com.hcl.repository.StudentRepository;
import com.hcl.util.GeneratePassword;
@RunWith(SpringJUnit4ClassRunner.class)
public class RegistrationserviceImplTest {

	@Mock
	private StudentRepository studentRepository;
	
	@Mock
	private GeneratePassword genPass;
	
	@InjectMocks
	private RegistrationserviceImpl registrationserviceImpl;
	
	@Test
	public void RegisterTest() {
		RegReqDto req=new RegReqDto();
		req.setEmail("Pradeep@gmail.com");
		req.setStudentName("Pradeep");
		req.setPhone("9845808462");
		Student student=new Student();
		BeanUtils.copyProperties(req, student);
		student.setStudentId(1);
		student.setPassword("PEED888E8P4");
		RegResDto res=new RegResDto();
		res.setMessage("Registration");
		res.setStatusCode(HttpStatus.CREATED.value());
		//Mockito.when(genPass.randomAlphaNumeric(req.getStudentName(), req.getPhone())).thenReturn("PEED888E8P4");
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		RegResDto actRes=registrationserviceImpl.registration(req);
		assertEquals(res.getStatusCode(), actRes.getStatusCode());
		
		
		
	}

}
