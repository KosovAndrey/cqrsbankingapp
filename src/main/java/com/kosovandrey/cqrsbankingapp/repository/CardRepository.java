package com.kosovandrey.cqrsbankingapp.repository;

import com.kosovandrey.cqrsbankingapp.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}
