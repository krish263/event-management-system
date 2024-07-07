package com.event.booking.system.project.security.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "csrf_tokens")
public class CustomCSRFTokens {

    public CustomCSRFTokens(){

    }

    public CustomCSRFTokens(String client_id, String token) {
        this.id = 0;
        this.clientId = client_id;
        this.token = token;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "client_id")
    private String clientId;

    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
