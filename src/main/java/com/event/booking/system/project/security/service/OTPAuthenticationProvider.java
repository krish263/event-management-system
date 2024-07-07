package com.event.booking.system.project.security.service;

import com.event.booking.system.project.proxy.AuthenticationServerProxy;
import com.event.booking.system.project.security.authentication.OTPAuthentication;
import com.event.booking.system.project.security.authentication.UPAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class OTPAuthenticationProvider implements AuthenticationProvider {

    private AuthenticationServerProxy authenticationServerProxy;

    @Autowired
    public OTPAuthenticationProvider(AuthenticationServerProxy authenticationServerProxy){
        this.authenticationServerProxy=authenticationServerProxy;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String code = authentication.getCredentials().toString();
        boolean isValid =  authenticationServerProxy.checkOtp(userName,code);
        if(isValid){
            return new OTPAuthentication(userName,code);
        }
        else{
            throw new BadCredentialsException("Wrong OTP");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OTPAuthentication.class.isAssignableFrom(authentication);
    }
}
