package com.kosovandrey.cqrsbankingapp.service.transaction;

import com.kosovandrey.cqrsbankingapp.domain.model.Transaction;
import com.kosovandrey.cqrsbankingapp.service.CommandService;
import com.kosovandrey.cqrsbankingapp.service.QueryService;

public interface TransactionService extends QueryService<Transaction>, CommandService<Transaction> {
}
