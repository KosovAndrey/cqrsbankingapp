package com.kosovandrey.cqrsbankingapp.repository;

import com.kosovandrey.cqrsbankingapp.events.AbstractEvent;
import com.kosovandrey.cqrsbankingapp.events.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}
