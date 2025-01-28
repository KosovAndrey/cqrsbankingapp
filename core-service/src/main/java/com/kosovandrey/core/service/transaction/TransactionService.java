package com.kosovandrey.core.service.transaction;

import com.kosovandrey.common.domain.model.Transaction;
import com.kosovandrey.core.service.CommandService;
import com.kosovandrey.common.service.QueryService;

public interface TransactionService extends QueryService<Transaction>, CommandService<Transaction> {
}
