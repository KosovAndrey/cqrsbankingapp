package com.kosovandrey.core.service.account;

import com.kosovandrey.common.domain.model.Account;
import com.kosovandrey.core.service.CommandService;
import com.kosovandrey.common.service.QueryService;

public interface AccountService
        extends QueryService<Account>, CommandService<Account> {
}
