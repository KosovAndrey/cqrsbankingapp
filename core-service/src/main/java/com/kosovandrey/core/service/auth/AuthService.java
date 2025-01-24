package com.kosovandrey.core.service.auth;

import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.core.web.dto.LoginRequestDto;
import com.kosovandrey.core.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto request);

    void register(Client client);

}
