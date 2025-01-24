package com.kosovandrey.core.web.security.jwt;

import lombok.Getter;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
public class TokenParameters {
    private final Map<String, Object> claims;
    private final String subject;
    private final Date issuedAt;
    private final Date expiredAt;
    private final String type;

    public static TokenParametersBuilder builder(
            String subject,
            String type,
            Duration duration
    ) {
        Date issuedAt = new Date();
        return new TokenParametersBuilder().claims(new HashMap<>())
                .type(type)
                .issuedAt(issuedAt)
                .subject(subject)
                .expiredAt(new Date(issuedAt.getTime()
                        + 1000L
                        * duration.get(ChronoUnit.SECONDS)
                ));
    }

    TokenParameters(
            Map<String, Object> claims,
            String subject,
            Date issuedAt,
            Date expiredAt,
            String type
    ) {
        this.claims = claims;
        this.subject = subject;
        this.issuedAt = issuedAt;
        this.expiredAt = expiredAt;
        this.type = type;
    }

    public static class TokenParametersBuilder {
        private Map<String, Object> claims;
        private String subject;
        private Date issuedAt;
        private Date expiredAt;
        private String type;

        public TokenParametersBuilder claims(Map<String, Object> claims) {
            if (this.claims != null) {
                this.claims.putAll(claims);
            } else {
                this.claims = new HashMap<>();
            }

            return this;
        }

        public TokenParametersBuilder issuedAt(Date issuedAt) {
            this.issuedAt = issuedAt;
            return this;
        }

        public TokenParametersBuilder expiredAt(Date expiredAt) {
            this.expiredAt = expiredAt;
            return this;
        }

        public TokenParametersBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public TokenParameters build() {
            return new TokenParameters(
                    this.claims,
                    this.subject,
                    this.issuedAt,
                    this.expiredAt,
                    this.type
            );
        }

        TokenParametersBuilder() {
        }

        private TokenParametersBuilder type(String type) {
            this.type = type;
            return this;
        }

        public String toString() {
            return "TokenParameters.TokenParametersBuilder("
                    + "claims=" + this.claims
                    + ", subject=" + this.subject
                    + ", issuedAt=" + this.issuedAt
                    + ", expiredAt=" + this.expiredAt
                    + ", type=" + this.type + ")";
        }
    }

}