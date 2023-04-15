package com.richkane.styloo.controller;

import com.richkane.styloo.persistence.dto.request.AuthenticationRequest;
import com.richkane.styloo.persistence.dto.response.UserDTO;

import java.util.List;

public interface IUserController {
    List<UserDTO> getAllUsers();
    UserDTO getUserByEmail(AuthenticationRequest request);
    UserDTO getUser(Long id);
    void deleteUser(String email);
}
