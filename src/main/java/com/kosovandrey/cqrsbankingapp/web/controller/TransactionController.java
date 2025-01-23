package com.kosovandrey.cqrsbankingapp.web.controller;

import com.kosovandrey.cqrsbankingapp.domain.model.Transaction;
import com.kosovandrey.cqrsbankingapp.service.card.CardService;
import com.kosovandrey.cqrsbankingapp.service.transaction.TransactionService;
import com.kosovandrey.cqrsbankingapp.web.dto.OnCreate;
import com.kosovandrey.cqrsbankingapp.web.dto.TransactionDto;
import com.kosovandrey.cqrsbankingapp.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    @PreAuthorize("@ssi.canAccessCard(#dto.from)")
    public void create(
            @RequestBody @Validated(OnCreate.class) final TransactionDto dto
    ) {
        if (!cardService.existsByNumberAndDate(
                dto.getTo().getNumber(), dto.getTo().getDate()
        )) {
            throw new IllegalStateException("Card number is not valid");
        }
        Transaction transaction = transactionMapper.fromDto(dto);
        transactionService.create(transaction);
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessTransaction(#id)")
    public TransactionDto getById(@PathVariable final UUID id) {
        Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }

}
