package com.beautix.backend.api.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

/**
 * Custom session authentication
 *
 * @author David Sapozhnik
 */
public class SessionAuthentication extends AbstractAuthenticationToken {

    private final UserSessionPrincipal principal;

    public SessionAuthentication(UserSessionPrincipal principal) {
        super(List.of(new SimpleGrantedAuthority(principal.role().name())));
        this.principal = principal;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserSessionPrincipal getPrincipal() {
        return principal;
    }
}
