package com.richkane.styloo.persistence.mapper;

import com.richkane.styloo.persistence.dto.response.RoleResponse;
import com.richkane.styloo.persistence.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleResponse roleToRoleDTO(Role role);
    Role roleDTOToRole(RoleResponse roleResponse);
    List<Role> roleDTOsToRoles(List<RoleResponse> roleResponses);
    List<RoleResponse> rolesToRoleDTOs(List<Role> roles);
}
