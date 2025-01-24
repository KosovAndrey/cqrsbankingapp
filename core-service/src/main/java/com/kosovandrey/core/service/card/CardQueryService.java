package com.kosovandrey.core.service.card;

import com.kosovandrey.common.domain.model.Card;
import com.kosovandrey.core.service.QueryService;

public interface CardQueryService extends QueryService<Card> {

    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);

}
