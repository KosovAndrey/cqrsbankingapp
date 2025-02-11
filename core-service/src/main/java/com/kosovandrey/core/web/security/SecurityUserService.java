package com.kosovandrey.core.web.security;

import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.core.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsService {

    private final ClientService clientService;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(
            String username
    ) throws UsernameNotFoundException {
        Client client = clientService.getByUsername(username);
        return new SecurityUser(client);
    }
}
