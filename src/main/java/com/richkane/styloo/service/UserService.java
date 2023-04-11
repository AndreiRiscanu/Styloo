package com.richkane.styloo.service;

import com.richkane.styloo.persistence.RoleEnum;
import com.richkane.styloo.persistence.dto.response.UserDTO;
import com.richkane.styloo.persistence.mapper.UserMapper;
import com.richkane.styloo.persistence.model.Role;
import com.richkane.styloo.persistence.model.User;
import com.richkane.styloo.persistence.repository.RoleRepository;
import com.richkane.styloo.persistence.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    UserRepository userRepository;
    RoleRepository roleRepository;
    UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = Mappers.getMapper(UserMapper.class);
    }

    public void addUser(UserDTO userDTO) {
        userRepository.findByEmail(userDTO.email()).ifPresent((user) -> {
            throw new EntityExistsException("There exists an account with the user email " + userDTO.email());
        });
        User user = userMapper.userDTOToUser(userDTO);
        Role role = roleRepository.findByName(RoleEnum.USER).get();
        user.setRoles(Set.of(role));
        roleRepository.save(role);
        userRepository.save(user);
    }

    public List<UserDTO> getAllUsers() {
        return userMapper.usersToUserDTOs(userRepository.findAll());
    }

    public UserDTO getUser(Long id) {
        return userMapper.userToUserDTO(userRepository.findById(id).get());
    }

    public UserDTO getUserByEmail(String email) {
        return userMapper.userToUserDTO(userRepository.findByEmail(email).get());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
        Hibernate.initialize(user.getRoles());
        return user;
    }
}
