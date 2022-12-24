package com.richkane.styloo.service;

import com.richkane.styloo.persistence.dto.UserDTO;
import com.richkane.styloo.persistence.mapper.UserMapper;
import com.richkane.styloo.persistence.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = Mappers.getMapper(UserMapper.class);
    }

    public void addUser(UserDTO userDTO) {
        userRepository.save(userMapper.userDTOToUser(userDTO));
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
