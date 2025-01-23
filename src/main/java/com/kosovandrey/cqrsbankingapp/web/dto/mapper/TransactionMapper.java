package com.kosovandrey.cqrsbankingapp.web.dto.mapper;

import com.kosovandrey.cqrsbankingapp.domain.model.Transaction;
import com.kosovandrey.cqrsbankingapp.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {
}
