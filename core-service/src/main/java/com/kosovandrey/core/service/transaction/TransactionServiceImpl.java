package com.kosovandrey.core.service.transaction;

import com.kosovandrey.common.domain.model.Transaction;
import com.kosovandrey.common.service.transaction.TransactionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionCommandService commandService;
    private final TransactionQueryService queryService;

    @Override
    public void create(final Transaction object) {
        commandService.create(object);
    }

    @Override
    public Transaction getById(final UUID id) {
        return queryService.getById(id);
    }

}
