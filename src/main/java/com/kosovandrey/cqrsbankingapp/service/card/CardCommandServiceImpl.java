package com.kosovandrey.cqrsbankingapp.service.card;

import com.kosovandrey.cqrsbankingapp.domain.model.Card;
import com.kosovandrey.cqrsbankingapp.events.CardCreateEvent;
import com.kosovandrey.cqrsbankingapp.service.event.EventService;
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
