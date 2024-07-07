package com.event.booking.system.project.security;

import com.event.booking.system.project.security.filters.AuthenticationLogFilter;
import com.event.booking.system.project.security.filters.InitialLoginFilter;
import com.event.booking.system.project.security.filters.JWTVerifyFilter;
import com.event.booking.system.project.security.service.CustomCSRFRepository;
import com.event.booking.system.project.security.service.OTPAuthenticationProvider;
import com.event.booking.system.project.security.service.UPAuthenticationProvider;
import com.event.booking.system.project.security.service.UserPasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig{

//    @Autowired
//    private CsrfTokenRepository CustomCSRFRepository;

    @Autowired
    private UserPasswordAuthenticationProvider userPasswordAuthenticationProvider;

    @Autowired
    private OTPAuthenticationProvider otpAuthenticationProvider;

    @Autowired
    private JWTVerifyFilter jwtVerifyFilter;

    @Autowired
    private InitialLoginFilter initialLoginFilter;

    @Bean
    public AuthenticationLogFilter authenticationLogFilter(){
        return new AuthenticationLogFilter();
    }

    @Bean
    public AuthenticationProvider custmAuthenticationProvider(){
        return new UPAuthenticationProvider();
    }

//    @Bean
//    public CsrfTokenRepository csrfTokenRepository(){
//        return new CustomCSRFRepository();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        Map<String,PasswordEncoder> encoders = new HashMap<>();
        encoders.put("noop",NoOpPasswordEncoder.getInstance());
        encoders.put("bcrypt",new BCryptPasswordEncoder());
        encoders.put("scrypt",new SCryptPasswordEncoder(16384, 8, 1, 32, 64));
        return new DelegatingPasswordEncoder("bcrypt",encoders);
    }


    @Bean
    public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception{
        http.httpBasic(c -> {
            c.realmName("OTHER");
            c.authenticationEntryPoint(new CustomEntryPoint());
        });
        http.authenticationProvider(userPasswordAuthenticationProvider).authenticationProvider(otpAuthenticationProvider);
        http.csrf(c->{
            c.disable();
        });
        http.addFilterAt(jwtVerifyFilter,BasicAuthenticationFilter.class)
                .addFilterAt(initialLoginFilter,BasicAuthenticationFilter.class);
        http.authorizeHttpRequests(auth->{
           auth.anyRequest().authenticated();
        });
        return http.build();
    }




//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.httpBasic(c -> {
//            c.realmName("OTHER");
//            c.authenticationEntryPoint(new CustomEntryPoint());
//        });
//        http.authenticationProvider(custmAuthenticationProvider());
//
//        http.addFilterAfter(authenticationLogFilter(), BasicAuthenticationFilter.class);
//
//        http.authorizeHttpRequests((auth) -> auth
//                        .requestMatchers(HttpMethod.GET,"/user/**").hasAnyRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST,"/celebrity/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST,"/city/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST,"/movies/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST,"/theater/**").hasRole("ADMIN")
//                        .anyRequest().permitAll());
//
//        http.csrf(c->{
////            HandlerMappingIntrospector i = new HandlerMappingIntrospector();
////            MvcRequestMatcher r = new MvcRequestMatcher(i, "/user");
////            c.ignoringRequestMatchers(r);
////            c.csrfTokenRepository(CustomCSRFRepository);
//            c.disable();
//        });
//
//
//
//        return http.build();
//    }

//    @Autowired
//    private UPAuthenticationProvider upAuthenticationProvider;

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
//        return new ProviderManager(Collections.singletonList(authenticationProvider));
//    }
}
