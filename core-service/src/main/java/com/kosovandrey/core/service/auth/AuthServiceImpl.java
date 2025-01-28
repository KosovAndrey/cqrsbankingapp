package com.kosovandrey.core.service.auth;

import com.kosovandrey.common.domain.exception.ResourceAlreadyExistsException;
import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.core.service.client.ClientService;
import com.kosovandrey.core.web.dto.LoginRequestDto;
import com.kosovandrey.core.web.dto.LoginResponseDto;
import com.kosovandrey.core.web.security.jwt.JwtProperties;
import com.kosovandrey.core.web.security.jwt.TokenParameters;
import com.kosovandrey.core.web.security.jwt.TokenService;
import com.kosovandrey.core.web.security.jwt.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final TokenService tokenService;
    private final ClientService service;
    private final JwtProperties jwtProperties;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDto login(final LoginRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        LoginResponseDto response = new LoginResponseDto();
        response.setAccess(
                tokenService.create(
                        TokenParameters.builder(
                                        request.getUsername(),
                                        TokenType.ACCESS.name(),
                                        jwtProperties.getAccess()
                                )
                                .build()
                )
        );
        return response;
    }

    @Override
    public void register(final Client client) {
        if (service.existsByUsername(client.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        service.create(client);
    }

}
