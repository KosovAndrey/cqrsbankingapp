package com.kosovandrey.common.events;

import com.kosovandrey.common.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);

}
