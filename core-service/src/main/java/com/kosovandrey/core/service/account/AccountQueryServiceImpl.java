package com.kosovandrey.core.service.account;

import com.kosovandrey.common.domain.exception.ResourceNotFoundException;
import com.kosovandrey.common.domain.model.Account;
import com.kosovandrey.common.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService {

    private final AccountRepository repository;

    @Override
    public Account getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
