package com.richkane.styloo.service;

import com.richkane.styloo.persistence.dto.UserDTO;
import com.richkane.styloo.persistence.mapper.UserMapper;
import com.richkane.styloo.persistence.model.Role;
import com.richkane.styloo.persistence.model.User;
import com.richkane.styloo.persistence.repository.RoleRepository;
import com.richkane.styloo.persistence.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;
    UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = Mappers.getMapper(UserMapper.class);
    }

    public void addUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        user.setRoles(userDTO.roles().stream()
                .map(role -> {
                    Role r = roleRepository.findByName(role.name()).orElseThrow();
                    r.getUsers().add(user);
                    return r;
                })
                .collect(Collectors.toSet()));
        userRepository.save(user);
    }

    public List<UserDTO> getAllUsers() {
        return userMapper.usersToUserDTOs(userRepository.findAll());
    }

    public UserDTO getUser(Long id) {
        return userMapper.userToUserDTO(userRepository.findById(id).get());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
