package com.event.booking.system.project.security.service;

import com.event.booking.system.project.proxy.AuthenticationServerProxy;
import com.event.booking.system.project.security.authentication.UPAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordAuthenticationProvider implements AuthenticationProvider {
    private AuthenticationServerProxy authenticationServerProxy;

    @Autowired
    public UserPasswordAuthenticationProvider(AuthenticationServerProxy authenticationServerProxy){
        this.authenticationServerProxy=authenticationServerProxy;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String pwd = authentication.getCredentials().toString();
//        try{
//            authenticationServerProxy.validateUP(userName,pwd);
//        }
//        catch(Exception e){
//            throw new BadCredentialsException("Invalid username or password");
//        }
        authenticationServerProxy.validateUP(userName,pwd);

        return new UPAuthentication(userName,pwd);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UPAuthentication.class.isAssignableFrom(authentication);
    }
}
