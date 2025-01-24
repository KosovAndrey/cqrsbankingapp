package com.kosovandrey.common.repository;

import com.kosovandrey.common.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    boolean existsByUsername(String username);

    Optional<Client> findByUsername(String username);
}
