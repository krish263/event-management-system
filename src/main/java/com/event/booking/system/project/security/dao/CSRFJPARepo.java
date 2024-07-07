package com.event.booking.system.project.security.dao;

import com.event.booking.system.project.security.entity.CustomCSRFTokens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CSRFJPARepo extends JpaRepository<CustomCSRFTokens,Long> {
    public Optional<CustomCSRFTokens> findCSRFTokensByClientId(String clientId);
}
