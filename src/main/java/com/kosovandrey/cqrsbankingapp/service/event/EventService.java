package com.kosovandrey.cqrsbankingapp.service.event;

import com.kosovandrey.cqrsbankingapp.events.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);
}
