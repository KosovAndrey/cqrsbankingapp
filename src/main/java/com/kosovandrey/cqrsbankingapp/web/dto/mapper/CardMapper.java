package com.kosovandrey.cqrsbankingapp.web.dto.mapper;

import com.kosovandrey.cqrsbankingapp.domain.model.Card;
import com.kosovandrey.cqrsbankingapp.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
