package com.event.booking.system.project.security.service;

import com.event.booking.system.project.security.dao.CSRFJPARepo;
import com.event.booking.system.project.security.entity.CustomCSRFTokens;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomCSRFRepository implements CsrfTokenRepository {

    private CSRFJPARepo csrfjpaRepo;

    @Autowired
    public CustomCSRFRepository(CSRFJPARepo csrfjpaRepo){
        this.csrfjpaRepo=csrfjpaRepo;
    }

    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString();
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid);
    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
//        String client_id = request.getHeader("X-IDENTIFIER");
//        Optional<CustomCSRFTokens>customCSRFTokens =  csrfjpaRepo.findCSRFTokensByClientId(client_id);
//        if(customCSRFTokens.isEmpty()){
//            CustomCSRFTokens customCSRFTokens1 = new CustomCSRFTokens(client_id,token.getToken());
//            csrfjpaRepo.save(customCSRFTokens1);
//        }
//        else{
//            CustomCSRFTokens tokens =new CustomCSRFTokens();
//            tokens.setToken(tokens.getToken());
//            tokens.setClientId(client_id);
//        }
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
//        String client_id = request.getHeader("X-IDENTIFIER");
//        Optional<CustomCSRFTokens>customCSRFTokens =  csrfjpaRepo.findCSRFTokensByClientId(client_id);
//        if(customCSRFTokens.isPresent()){
//            return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf",customCSRFTokens.get().getToken());
//        }
        return null;
    }
}
