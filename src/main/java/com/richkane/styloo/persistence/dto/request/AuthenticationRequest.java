package com.richkane.styloo.persistence.dto.request;

public record AuthenticationRequest(String email,
                                    String password) { }
