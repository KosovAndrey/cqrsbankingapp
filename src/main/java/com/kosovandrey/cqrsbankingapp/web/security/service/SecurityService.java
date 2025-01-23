package com.kosovandrey.cqrsbankingapp.web.security.service;

import com.kosovandrey.cqrsbankingapp.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessTransaction(UUID transactionId);
}
