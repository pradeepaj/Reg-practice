package com.hcl.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.LoginReqDto;
import com.hcl.dto.LoginResDto;
import com.hcl.entity.Student;
import com.hcl.exception.UserNotFoundException;
import com.hcl.repository.StudentRepository;
import com.hcl.util.TrainingConstants;
/**
 * 
 * @author Pradeep AJ
 *
 */

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * Student  login implementation 
	 * @param LoginReqDto
	 * @return LoginResDto
	 * @exception UserNotFoundException
	 */
	
	@Override
	public LoginResDto login(LoginReqDto reqDto) {
		Optional<Student> student=studentRepository.findByEmailAndPassword(reqDto.getEmail(),reqDto.getPassword());
		
		if(student.isPresent()) {
			logger.info("Valid User");
			LoginResDto resDto=new LoginResDto();
			resDto.setMessage(TrainingConstants.LOGIN_RESPONSE_MESSAGE);
			resDto.setStatusCode(TrainingConstants.OK);
			return resDto;
		}
		else {
			throw new UserNotFoundException(TrainingConstants.LOGIN_EXCEPTION_RESPONSE_MESSAGE);
		}
		
		
	}

}
