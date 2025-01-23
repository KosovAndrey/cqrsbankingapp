package com.kosovandrey.cqrsbankingapp.service.account;

import com.kosovandrey.cqrsbankingapp.domain.model.Account;
import com.kosovandrey.cqrsbankingapp.service.CommandService;
import com.kosovandrey.cqrsbankingapp.service.QueryService;

public interface AccountService
        extends QueryService<Account>, CommandService<Account> {
}
