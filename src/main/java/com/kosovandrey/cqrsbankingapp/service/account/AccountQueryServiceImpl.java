package com.kosovandrey.cqrsbankingapp.service.account;

import com.kosovandrey.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import com.kosovandrey.cqrsbankingapp.domain.model.Account;
import com.kosovandrey.cqrsbankingapp.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService {

    private final AccountRepository repository;

    @Override
    public Account getById(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

}
