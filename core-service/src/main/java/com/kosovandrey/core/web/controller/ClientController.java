package com.kosovandrey.core.web.controller;

import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.core.service.client.ClientService;
import com.kosovandrey.core.web.dto.AccountDto;
import com.kosovandrey.core.web.dto.CardDto;
import com.kosovandrey.core.web.dto.ClientDto;
import com.kosovandrey.core.web.dto.mapper.AccountMapper;
import com.kosovandrey.core.web.dto.mapper.CardMapper;
import com.kosovandrey.core.web.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
@Validated
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final CardMapper cardMapper;
    private final AccountMapper accountMapper;

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessClient(#id)")
    public ClientDto getById(
            @PathVariable final UUID id
    ) {
        Client client = clientService.getById(id);
        return clientMapper.toDto(client);
    }

    @GetMapping("/{id}/cards")
    @PreAuthorize("@ssi.canAccessClient(#id)")
    public List<CardDto> getCardsById(
            @PathVariable final UUID id
    ) {
        Client client = clientService.getById(id);
        return cardMapper.toDto(client.getCards());
    }

    @GetMapping("/{id}/account")
    @PreAuthorize("@ssi.canAccessClient(#id)")
    public AccountDto getAccountById(
            @PathVariable final UUID id
    ) {
        Client client = clientService.getById(id);
        return accountMapper.toDto(client.getAccount());
    }

}
