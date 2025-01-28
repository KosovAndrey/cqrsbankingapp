package com.kosovandrey.core.service.card;

import com.kosovandrey.common.domain.model.Card;
import com.kosovandrey.core.service.CommandService;
import com.kosovandrey.common.service.QueryService;

import java.util.UUID;

public interface CardService extends QueryService<Card>, CommandService<Card> {

    void createByClientId(UUID clientId);

    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);

    Card getByNumberAndDate(String number, String date);
}
