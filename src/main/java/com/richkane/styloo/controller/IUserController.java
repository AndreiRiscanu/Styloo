package com.richkane.styloo.controller;

import com.richkane.styloo.persistence.dto.response.UserDTO;

import java.util.List;

public interface IUserController {
    void addUser(UserDTO user);
    List<UserDTO> getAllUsers();
    UserDTO getUserByEmail(String email);
    UserDTO getUser(Long id);
    void deleteUser(Long id);
}
