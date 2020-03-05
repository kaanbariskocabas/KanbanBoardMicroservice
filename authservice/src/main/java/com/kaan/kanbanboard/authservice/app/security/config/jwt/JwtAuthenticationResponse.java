package com.kaan.kanbanboard.authservice.app.security.config.jwt;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable  {

    private static final long serialVersionUID = -8241539452820631896L;
    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
