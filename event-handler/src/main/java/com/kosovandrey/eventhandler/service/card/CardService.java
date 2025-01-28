package com.kosovandrey.eventhandler.service.card;

import com.kosovandrey.common.domain.model.Card;

import java.math.BigDecimal;
import java.util.UUID;

public interface CardService {

    Card getById(UUID id);

    Card create(Card card);

    void add(Card card, BigDecimal amount);

    void addTransaction(UUID cardId, UUID transactionId);

}
