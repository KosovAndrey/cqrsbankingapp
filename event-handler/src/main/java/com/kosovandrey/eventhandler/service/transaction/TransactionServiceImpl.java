package com.kosovandrey.eventhandler.service.transaction;

import com.kosovandrey.common.domain.model.Card;
import com.kosovandrey.common.domain.model.Transaction;
import com.kosovandrey.common.repository.TransactionRepository;
import com.kosovandrey.eventhandler.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final CardService cardService;

    @Override
    @Transactional
    public Transaction create(final Transaction transaction) {
        Card cardFrom = transaction.getFrom();
        Card cardTo = transaction.getTo();
        checkBalance(cardFrom, transaction.getAmount());
        cardService.add(cardFrom, transaction.getAmount().negate());
        cardService.add(cardTo, transaction.getAmount());
        repository.save(transaction);
        cardService.addTransaction(cardTo.getId(), transaction.getId());
        cardService.addTransaction(cardFrom.getId(), transaction.getId());
        return transaction;
    }

    private void checkBalance(final Card cardFrom, final BigDecimal amount) {
        if (cardFrom.getAccount().getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Not enough money on card account");
        }
    }
}
