package com.event.booking.system.project.security.filters;

import com.event.booking.system.project.security.authentication.OTPAuthentication;
import com.event.booking.system.project.security.authentication.UPAuthentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class InitialLoginFilter extends OncePerRequestFilter {

    @Value("${jwt.signing.key}")
    private String signingKey;


    @Bean
    protected AuthenticationManager authenticationManager()
            throws Exception {
        return new ProviderManager();
    }



    public InitialLoginFilter(){
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String userName = request.getHeader("username");
        String password = request.getHeader("password");
        String code = request.getHeader("code");
        AuthenticationManager authenticationManager;
        try {
            authenticationManager = authenticationManager();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(code!=null){
            Authentication authentication = new UPAuthentication(userName,password);
            authenticationManager.authenticate(authentication);
        }
        else{
            Authentication authentication = new OTPAuthentication(userName,code);
            authentication = authenticationManager.authenticate(authentication);
            SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder()
                        .setClaims(Map.of("username",userName))
                        .signWith(key).compact();
            response.setHeader("Authorization", jwt);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        return !request.getServletPath().equals("/login");
    }
}
