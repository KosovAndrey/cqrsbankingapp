package com.kosovandrey.cqrsbankingapp.service.client;

import com.kosovandrey.cqrsbankingapp.domain.model.Client;
import com.kosovandrey.cqrsbankingapp.service.CommandService;
import com.kosovandrey.cqrsbankingapp.service.QueryService;

public interface ClientService extends QueryService<Client>, CommandService<Client> {
}
