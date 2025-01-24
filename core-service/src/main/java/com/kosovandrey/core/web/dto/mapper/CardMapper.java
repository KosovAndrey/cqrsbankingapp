package com.kosovandrey.core.web.dto.mapper;

import com.kosovandrey.common.domain.model.Card;
import com.kosovandrey.core.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
