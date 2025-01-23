package com.kosovandrey.cqrsbankingapp.events;

import com.kosovandrey.cqrsbankingapp.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);

}
