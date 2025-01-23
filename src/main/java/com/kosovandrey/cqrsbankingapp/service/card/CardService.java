package com.kosovandrey.cqrsbankingapp.service.card;

import com.kosovandrey.cqrsbankingapp.domain.model.Card;
import com.kosovandrey.cqrsbankingapp.service.CommandService;
import com.kosovandrey.cqrsbankingapp.service.QueryService;

public interface CardService extends QueryService<Card>, CommandService<Card> {
}
