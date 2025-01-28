package com.kosovandrey.core.web.dto.mapper;

import com.kosovandrey.common.domain.model.Transaction;
import com.kosovandrey.core.web.dto.TransactionDto;
import org.mapstruct.Mapper;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        uses = CardMapper.class,
        injectionStrategy = CONSTRUCTOR
)
public interface TransactionMapper
        extends Mappable<Transaction, TransactionDto> {
}
