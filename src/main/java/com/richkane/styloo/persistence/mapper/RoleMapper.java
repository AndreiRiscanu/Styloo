package com.richkane.styloo.persistence.mapper;

import com.richkane.styloo.persistence.dto.response.RoleDTO;
import com.richkane.styloo.persistence.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleDTO roleToRoleDTO(Role role);
    Role roleDTOToRole(RoleDTO roleDTO);
    List<Role> roleDTOsToRoles(List<RoleDTO> roleDTOs);
    List<RoleDTO> rolesToRoleDTOs(List<Role> roles);
}
