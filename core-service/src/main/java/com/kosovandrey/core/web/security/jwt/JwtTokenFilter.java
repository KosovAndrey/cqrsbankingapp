package com.kosovandrey.core.web.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;

@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final TokenService jwtService;
    private final UserDetailsService userDetailsService;


    @Override
    @SneakyThrows
    public void doFilter(
            final ServletRequest servletRequest,
            final ServletResponse servletResponse,
            final FilterChain filterChain
    ) {
        try {
            String token = resolve((HttpServletRequest) servletRequest);
            if (!token.isEmpty()
                    && jwtService.getType(token).equals(TokenType.ACCESS.name())
                    && !jwtService.isExpired(token)
            ) {
                Authentication authentication = getAuthentication(token);
                if (authentication != null) {
                    SecurityContextHolder.getContext()
                            .setAuthentication(authentication);
                }
            }
        } catch (Exception ignored) {
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String resolve(final HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private Authentication getAuthentication(final String token) {
        String subject = jwtService.getSubject(token);
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(subject);
        if (userDetails != null) {
            return new UsernamePasswordAuthenticationToken(
                    userDetails, "", userDetails.getAuthorities()
            );
        }
        return null;
    }
}
