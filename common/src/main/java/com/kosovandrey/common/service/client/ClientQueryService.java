package com.kosovandrey.common.service.client;

import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.common.service.QueryService;

import java.util.UUID;

public interface ClientQueryService extends QueryService<Client> {

    boolean existsByUsername(String username);

    Client getByUsername(String username);

    Client getByAccount(UUID accountId);
}
