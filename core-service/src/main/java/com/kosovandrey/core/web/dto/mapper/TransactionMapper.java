package com.kosovandrey.core.web.dto.mapper;

import com.kosovandrey.common.domain.model.Transaction;
import com.kosovandrey.core.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper
        extends Mappable<Transaction, TransactionDto> {
}
