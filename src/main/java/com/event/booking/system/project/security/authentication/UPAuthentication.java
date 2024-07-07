package com.event.booking.system.project.security.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UPAuthentication extends UsernamePasswordAuthenticationToken {
    public UPAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public UPAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
