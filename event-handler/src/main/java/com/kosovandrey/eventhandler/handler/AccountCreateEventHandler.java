package com.kosovandrey.eventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kosovandrey.common.domain.model.Account;
import com.kosovandrey.common.events.AccountCreateEvent;
import com.kosovandrey.eventhandler.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component("ACCOUNT_CREATE")
@RequiredArgsConstructor
public class AccountCreateEventHandler implements EventHandler {

    private final AccountService service;
    private final Gson gson;

    @Override
    public void handle(
            final JsonObject object,
            final Acknowledgment acknowledgment
    ) {
        AccountCreateEvent event = gson.fromJson(
                object,
                AccountCreateEvent.class
        );
        Account account = gson.fromJson(
                (String) event.getPayload(),
                Account.class
        );
        service.create(account);
        acknowledgment.acknowledge();
    }
}
