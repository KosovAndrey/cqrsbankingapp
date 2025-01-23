package com.kosovandrey.cqrsbankingapp.service.card;

import com.kosovandrey.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import com.kosovandrey.cqrsbankingapp.domain.model.Card;
import com.kosovandrey.cqrsbankingapp.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository repository;

    @Override
    public Card getById(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

}
