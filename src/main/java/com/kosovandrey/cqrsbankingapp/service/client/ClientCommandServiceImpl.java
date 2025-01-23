package com.kosovandrey.cqrsbankingapp.service.client;

import com.kosovandrey.cqrsbankingapp.domain.model.Client;
import com.kosovandrey.cqrsbankingapp.events.ClientCreateEvent;
import com.kosovandrey.cqrsbankingapp.service.event.EventService;
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
