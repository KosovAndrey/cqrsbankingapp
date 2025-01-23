package com.kosovandrey.cqrsbankingapp.service.client;

import com.kosovandrey.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import com.kosovandrey.cqrsbankingapp.domain.model.Client;
import com.kosovandrey.cqrsbankingapp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService {

    private final ClientRepository repository;

    @Override
    public Client getById(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

}
