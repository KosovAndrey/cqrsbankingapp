package com.kosovandrey.common.service.transaction;

import com.kosovandrey.common.domain.exception.ResourceNotFoundException;
import com.kosovandrey.common.domain.model.Transaction;
import com.kosovandrey.common.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository repository;

    @Override
    public Transaction getById(final UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
