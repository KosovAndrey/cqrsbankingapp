package com.kosovandrey.core.web.security.jwt;

import java.util.Date;

public interface TokenService {

    String create(TokenParameters var1);

    boolean isExpired(String var1);

    boolean isExpired(String var1, Date var2);

    String getSubject(String var1);

    String getType(String var1);

}
