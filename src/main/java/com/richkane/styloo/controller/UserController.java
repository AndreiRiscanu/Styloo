package com.richkane.styloo.controller;

import com.richkane.styloo.persistence.dto.request.AuthenticationRequest;
import com.richkane.styloo.persistence.dto.response.CartDTO;
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

    @GetMapping("/all")
    @Override
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping
    @Override
    public UserDTO getUserByEmail(@RequestBody AuthenticationRequest request) {
        return userService.getUserByEmail(request.email());
    }

    @GetMapping("/{id}")
    @Override
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{email}")
    @Override
    public void deleteUser(@PathVariable String email) {
        userService.deleteUserByEmail(email);
    }
}
