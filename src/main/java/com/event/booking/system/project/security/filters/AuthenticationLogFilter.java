package com.event.booking.system.project.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class AuthenticationLogFilter extends OncePerRequestFilter {

    private final Logger logger = Logger.getLogger(AuthenticationLogFilter.class.getName());
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String s = request.getHeader("msg");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            String []auth={"Roles:\t"};
            authentication.getAuthorities().forEach((a)->logger.info(auth[0]+=a.getAuthority()+","));
            String stringBuilder = "\n******************** - Successfully authenticated user - *******************************\n" +
                    String.format("Details:\nname:\t%s\n", authentication.getName()) +
                    auth[0].substring(0, auth[0].length() - 1) +
                    "\n" +
                    "******************** - Successfully authenticated user - *******************************";
            logger.info(stringBuilder);
        }

        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return false;
    }
}
