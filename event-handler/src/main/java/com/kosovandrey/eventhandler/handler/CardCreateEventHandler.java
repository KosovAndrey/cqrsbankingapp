package com.kosovandrey.eventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kosovandrey.common.domain.model.Card;
import com.kosovandrey.common.events.CardCreateEvent;
import com.kosovandrey.eventhandler.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component("CARD_CREATE")
@RequiredArgsConstructor
public class CardCreateEventHandler implements EventHandler {

    private final CardService service;
    private final Gson gson;

    @Override
    public void handle(
            final JsonObject object,
            final Acknowledgment acknowledgment
    ) {
        CardCreateEvent event = gson.fromJson(
                object,
                CardCreateEvent.class
        );
        Card card = gson.fromJson(
                (String) event.getPayload(),
                Card.class
        );
        service.create(card);
        acknowledgment.acknowledge();
    }
}
