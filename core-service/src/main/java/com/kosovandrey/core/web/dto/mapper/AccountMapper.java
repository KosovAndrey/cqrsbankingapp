package com.kosovandrey.core.web.dto.mapper;

import com.kosovandrey.common.domain.model.Account;
import com.kosovandrey.core.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
