package com.kosovandrey.core.service.client;

import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.core.service.CommandService;
import com.kosovandrey.common.service.QueryService;

public interface ClientService
        extends QueryService<Client>, CommandService<Client> {

    boolean existsByUsername(String username);

    Client getByUsername(String username);

}
