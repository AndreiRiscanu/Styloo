package com.richkane.styloo.controller;

import com.richkane.styloo.persistence.dto.request.AuthenticationRequest;
import com.richkane.styloo.persistence.dto.response.UserResponse;
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

    @GetMapping("/all")
    @Override
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping
    @Override
    public UserResponse getUserByEmail(@RequestBody AuthenticationRequest request) {
        return userService.getUserByEmail(request.email());
    }

    @GetMapping("/{id}")
    @Override
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{email}")
    @Override
    public void deleteUserByEmail(@PathVariable String email) {
        userService.deleteUserByEmail(email);
    }
}
