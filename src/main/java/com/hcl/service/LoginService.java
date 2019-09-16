package com.hcl.service;

import com.hcl.dto.LoginReqDto;
import com.hcl.dto.LoginResDto;

public interface LoginService {

	LoginResDto login(LoginReqDto reqDto);

}
