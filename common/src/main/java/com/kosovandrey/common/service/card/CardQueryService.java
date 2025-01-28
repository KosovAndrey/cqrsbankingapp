package com.kosovandrey.common.service.card;

import com.kosovandrey.common.domain.model.Card;
import com.kosovandrey.common.service.QueryService;

public interface CardQueryService extends QueryService<Card> {

    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);

    Card getByNumberAndDate(String number, String date);

}
