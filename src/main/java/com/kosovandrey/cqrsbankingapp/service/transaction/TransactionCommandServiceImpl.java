package com.kosovandrey.cqrsbankingapp.service.transaction;

import com.kosovandrey.cqrsbankingapp.domain.model.Transaction;
import com.kosovandrey.cqrsbankingapp.events.TransactionCreateEvent;
import com.kosovandrey.cqrsbankingapp.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl
        implements TransactionCommandService {

    private final EventService eventService;

    @Override
    public void create(Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }

}
