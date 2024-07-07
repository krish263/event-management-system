package com.event.booking.system.project.proxy;

import com.event.booking.system.project.dto.OTPDTO;
import com.event.booking.system.project.dto.UserDTO;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationServerProxy {



    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public AuthenticationServerProxy(){

    }

    @Value("${auth.server.url}")
    private String authServerURL;

    public void validateUP(String userName,String pwd){
        String url = authServerURL+"/user/auth";
        var body = new UserDTO(userName,pwd);
        var request = new HttpEntity<>(body);
        getRestTemplate().postForEntity(url,request,Void.class);
    }

    public boolean checkOtp(String userName,String code){
        String url = authServerURL+"/otp/check";
        var body = new OTPDTO(userName,code);
        var request = new HttpEntity<>(body);
        var resp = getRestTemplate().postForEntity(url,request,Void.class);
        return resp.getStatusCode().equals(HttpStatus.OK);
    }
}
