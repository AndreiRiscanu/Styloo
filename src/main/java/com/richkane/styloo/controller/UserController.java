package com.richkane.styloo.controller;

import com.richkane.styloo.persistence.dto.UserDTO;
import com.richkane.styloo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController implements IUserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    @Override
    public void addUser(@RequestBody UserDTO user) {
        userService.addUser(user);
    }

    @GetMapping("/users")
    @Override
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    @Override
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/user")
    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
