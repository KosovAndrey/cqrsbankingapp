package com.kosovandrey.cqrsbankingapp.web.dto.mapper;

import com.kosovandrey.cqrsbankingapp.domain.model.Account;
import com.kosovandrey.cqrsbankingapp.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
