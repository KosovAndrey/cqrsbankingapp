package com.kosovandrey.core.service.client;

import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.common.events.ClientCreateEvent;
import com.kosovandrey.core.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientCommandServiceImpl implements ClientCommandService {

    private final EventService eventService;

    @Override
    public void create(Client object) {
        ClientCreateEvent event = new ClientCreateEvent(object);
        eventService.create(event);
    }

}
