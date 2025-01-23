package com.kosovandrey.cqrsbankingapp.service.auth;

import com.kosovandrey.cqrsbankingapp.domain.model.Client;
import com.kosovandrey.cqrsbankingapp.web.dto.LoginRequestDto;
import com.kosovandrey.cqrsbankingapp.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto request);

    void register(Client client);

}
