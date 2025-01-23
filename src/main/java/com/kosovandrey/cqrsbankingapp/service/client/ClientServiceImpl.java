package com.kosovandrey.cqrsbankingapp.service.client;

import com.kosovandrey.cqrsbankingapp.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientCommandService commandService;
    private final ClientQueryService queryService;

    @Override
    public void create(Client object) {
        commandService.create(object);
    }

    @Override
    public Client getById(UUID id) {
        return queryService.getById(id);
    }

}
