package com.kosovandrey.cqrsbankingapp.service.account;

import com.kosovandrey.cqrsbankingapp.domain.model.Account;
import com.kosovandrey.cqrsbankingapp.events.AccountCreateEvent;
import com.kosovandrey.cqrsbankingapp.service.event.EventService;
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
