package com.kosovandrey.core.service.account;

import com.kosovandrey.common.domain.model.Account;
import com.kosovandrey.common.events.AccountCreateEvent;
import com.kosovandrey.core.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private final EventService eventService;

    @Override
    public void create(Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }

}
