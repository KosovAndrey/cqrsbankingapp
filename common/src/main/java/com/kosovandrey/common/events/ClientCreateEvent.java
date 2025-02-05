package com.kosovandrey.common.events;

import com.kosovandrey.common.domain.aggregate.Aggregate;
import com.kosovandrey.common.domain.model.Client;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientCreateEvent extends AbstractEvent {

    public ClientCreateEvent(final Client payload) {
        super(null, EventType.CLIENT_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {

    }
}
