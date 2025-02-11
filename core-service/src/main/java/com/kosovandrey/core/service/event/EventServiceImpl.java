package com.kosovandrey.core.service.event;

import com.kosovandrey.common.events.AbstractEvent;
import com.kosovandrey.common.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    public void create(final AbstractEvent event) {
        repository.save(event);
    }

}
