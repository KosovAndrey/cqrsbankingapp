package com.kosovandrey.cqrsbankingapp.events;

import com.kosovandrey.cqrsbankingapp.domain.aggregate.Aggregate;
import com.kosovandrey.cqrsbankingapp.domain.model.Client;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientCreateEvent extends AbstractEvent {

    public ClientCreateEvent(Client payload) {
        super(null, EventType.CLIENT_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
