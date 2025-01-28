package com.kosovandrey.eventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.common.events.ClientCreateEvent;
import com.kosovandrey.eventhandler.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component("CLIENT_CREATE")
@RequiredArgsConstructor
public class ClientCreateEventHandler implements EventHandler {

    private final ClientService service;
    private final Gson gson;

    @Override
    public void handle(
            final JsonObject object,
            final Acknowledgment acknowledgment
    ) {
        ClientCreateEvent event = gson.fromJson(
                object,
                ClientCreateEvent.class
        );
        Client client = gson.fromJson(
                (String) event.getPayload(),
                Client.class
        );
        service.create(client);
        acknowledgment.acknowledge();
    }
}
