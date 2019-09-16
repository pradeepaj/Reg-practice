package com.hcl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.RegReqDto;
import com.hcl.dto.RegResDto;
import com.hcl.entity.Student;
import com.hcl.repository.StudentRepository;
import com.hcl.util.TrainingConstants;
import com.hcl.util.GeneratePassword;

/**
 * 
 * @author Pradeep AJ
 *
 */

@Service
public class RegistrationserviceImpl implements Registrationservice {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationserviceImpl.class);

	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * user Registration implementation 
	 * @param RegReqDto
	 * @return RegResDto
	 * {@link(com.hcl.util.GeneratePassword)- to Generate Password}
	 */

	@Override
	public RegResDto registration(RegReqDto reqDto) {

		Student student = new Student();
		BeanUtils.copyProperties(reqDto, student);
		String password = GeneratePassword.randomAlphaNumeric(reqDto.getStudentName(), reqDto.getPhone());
		student.setPassword(password);
		studentRepository.save(student);
		logger.info("Enter into  registraion().. UserId is {}",student.getStudentId());
		RegResDto resDto = new RegResDto();
		resDto.setMessage(TrainingConstants.REG_RESPONSE_MESSAGE);
		resDto.setPassword(password);
		resDto.setStatusCode(TrainingConstants.CREATED);
		return resDto;
	}

}
