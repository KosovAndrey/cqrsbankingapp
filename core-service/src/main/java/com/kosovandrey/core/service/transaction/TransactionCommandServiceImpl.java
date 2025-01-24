package com.kosovandrey.core.service.transaction;

import com.kosovandrey.common.domain.model.Transaction;
import com.kosovandrey.common.events.TransactionCreateEvent;
import com.kosovandrey.core.service.event.EventService;
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
