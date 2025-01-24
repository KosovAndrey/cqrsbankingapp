package com.kosovandrey.core.web.controller;

import com.kosovandrey.common.domain.model.Card;
import com.kosovandrey.core.service.card.CardService;
import com.kosovandrey.core.web.dto.CardDto;
import com.kosovandrey.core.web.dto.TransactionDto;
import com.kosovandrey.core.web.dto.mapper.CardMapper;
import com.kosovandrey.core.web.dto.mapper.TransactionMapper;
import com.kosovandrey.core.web.security.SecurityUser;
import com.kosovandrey.core.web.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final SecurityService securityService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        SecurityUser user = securityService.getUserFromRequest();
        cardService.createByClientId(user.getId());
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public CardDto getById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    public List<TransactionDto> getTransactionsByCardId(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }

}
