package com.kosovandrey.cqrsbankingapp.service.transaction;

import com.kosovandrey.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import com.kosovandrey.cqrsbankingapp.domain.model.Transaction;
import com.kosovandrey.cqrsbankingapp.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository repository;

    @Override
    public Transaction getById(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

}
