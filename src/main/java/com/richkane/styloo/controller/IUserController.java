package com.richkane.styloo.controller;

import com.richkane.styloo.persistence.dto.request.AuthenticationRequest;
import com.richkane.styloo.persistence.dto.response.UserResponse;

import java.util.List;

public interface IUserController {
    List<UserResponse> getAllUsers();
    UserResponse getUserByEmail(AuthenticationRequest request);
    UserResponse getUser(Long id);
    void deleteUserByEmail(String email);
}
