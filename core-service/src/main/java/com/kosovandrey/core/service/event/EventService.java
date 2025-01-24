package com.kosovandrey.core.service.event;

import com.kosovandrey.common.events.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);
}
