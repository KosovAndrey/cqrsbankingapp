package com.kosovandrey.core.service.card;

import com.kosovandrey.common.domain.model.Card;
import com.kosovandrey.common.events.CardCreateEvent;
import com.kosovandrey.core.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardCommandServiceImpl implements CardCommandService {

    private final EventService eventService;

    @Override
    public void create(Card object) {
        CardCreateEvent event = new CardCreateEvent(object);
        eventService.create(event);
    }

}
