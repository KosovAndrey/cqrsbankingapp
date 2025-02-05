package com.kosovandrey.core.service.card;

import com.kosovandrey.common.domain.model.Card;
import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.common.service.card.CardQueryService;
import com.kosovandrey.core.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardQueryService queryService;
    private final CardCommandService commandService;
    private final ClientService clientService;

    @Override
    public void create(final Card object) {
        commandService.create(object);
    }

    @Override
    public Card getById(final UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void createByClientId(final UUID clientId) {
        Client client = clientService.getById(clientId);
        Card card = new Card(client.getAccount());
        commandService.create(card);
    }

    @Override
    public boolean existsByNumberAndDate(
            final String number,
            final String date
    ) {
        return queryService.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(
            final String number,
            final String date,
            final String cvv
    ) {
        return queryService.getByNumberAndDateAndCvv(number, date, cvv);
    }

    @Override
    public Card getByNumberAndDate(final String number, final String date) {
        return queryService.getByNumberAndDate(number, date);
    }

}
