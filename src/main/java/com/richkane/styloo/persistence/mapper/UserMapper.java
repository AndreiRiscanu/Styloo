package com.richkane.styloo.persistence.mapper;

import com.richkane.styloo.persistence.dto.UserDTO;
import com.richkane.styloo.persistence.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

    List<User> userDTOsToUsers(List<UserDTO> userDTOList);

    List<UserDTO> usersToUserDTOs(List<User> users);
}
