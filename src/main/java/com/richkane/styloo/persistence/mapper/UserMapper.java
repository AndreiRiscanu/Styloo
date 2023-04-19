package com.richkane.styloo.persistence.mapper;

import com.richkane.styloo.persistence.dto.response.UserResponse;
import com.richkane.styloo.persistence.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {
        RoleMapper.class
})
public interface UserMapper {
    @Mapping(target = "roles", source = "roles")
    UserResponse userToUserDTO(User user);
    @Mapping(target = "roles", source = "roles")
    User userDTOToUser(UserResponse userResponse);
    List<User> userDTOsToUsers(List<UserResponse> userResponses);
    List<UserResponse> usersToUserDTOs(List<User> users);
}
