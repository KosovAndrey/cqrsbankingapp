package com.kosovandrey.core.service.client;

import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.common.service.client.ClientQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientCommandService commandService;
    private final ClientQueryService queryService;

    @Override
    public void create(final Client object) {
        commandService.create(object);
    }

    @Override
    public Client getById(final UUID id) {
        return queryService.getById(id);
    }

    @Override
    public Client getByUsername(final String username) {
        return queryService.getByUsername(username);
    }

    @Override
    public boolean existsByUsername(final String username) {
        return queryService.existsByUsername(username);
    }

}
