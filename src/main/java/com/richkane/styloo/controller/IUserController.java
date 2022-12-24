package com.richkane.styloo.controller;

import com.richkane.styloo.persistence.dto.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IUserController {
    void addUser(UserDTO user);
    List<UserDTO> getAllUsers();
    UserDTO getUser(Long id);
    void deleteUser(Long id);
}
