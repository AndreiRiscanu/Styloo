package com.richkane.styloo.controller;

import com.richkane.styloo.persistence.dto.response.UserDTO;
import com.richkane.styloo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController implements IUserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Override
    public void addUser(@RequestBody UserDTO user) {
        userService.addUser(user);
    }

    @GetMapping("/all")
    @Override
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping
    @Override
    public UserDTO getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/{id}")
    @Override
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
