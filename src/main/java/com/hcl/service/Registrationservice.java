package com.hcl.service;

import com.hcl.dto.RegReqDto;
import com.hcl.dto.RegResDto;

public interface Registrationservice {

	RegResDto registration(RegReqDto reqDto);

}
