package com.richkane.styloo.controller;

import com.richkane.styloo.persistence.dto.request.AuthenticationRequest;
import com.richkane.styloo.persistence.dto.response.AuthenticationResponse;
import org.springframework.http.ResponseEntity;

/**
 * Interface defining the registering and authentication of users.
 */
public interface IAuthenticationController {
    ResponseEntity<AuthenticationResponse> register(AuthenticationRequest request);
    ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request);
}
