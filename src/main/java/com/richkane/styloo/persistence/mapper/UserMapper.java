package com.richkane.styloo.persistence.mapper;

import com.richkane.styloo.persistence.dto.UserDTO;
import com.richkane.styloo.persistence.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {
        RoleMapper.class
})
public interface UserMapper {
    @Mapping(target = "roles", source = "roles")
    @Mapping(target = "cart", source = "cart")
    UserDTO userToUserDTO(User user);
    @Mapping(target = "roles", source = "roles")
    @Mapping(target = "cart", source = "cart")
    User userDTOToUser(UserDTO userDTO);
    List<User> userDTOsToUsers(List<UserDTO> userDTOs);
    List<UserDTO> usersToUserDTOs(List<User> users);
}
