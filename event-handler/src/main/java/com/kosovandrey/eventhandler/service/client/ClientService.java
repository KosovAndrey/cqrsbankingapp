package com.kosovandrey.eventhandler.service.client;

import com.kosovandrey.common.domain.model.Client;

import java.util.UUID;

public interface ClientService {

    Client create(Client client);

    void addCard(UUID clientId, UUID cardId);

}
