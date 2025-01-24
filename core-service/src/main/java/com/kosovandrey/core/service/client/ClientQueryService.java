package com.kosovandrey.core.service.client;

import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.core.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {

    boolean existsByUsername(String username);

    Client getByUsername(String username);
}
