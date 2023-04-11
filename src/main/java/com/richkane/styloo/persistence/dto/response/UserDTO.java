package com.richkane.styloo.persistence.dto.response;

import java.util.Set;

public record UserDTO(String email,
                      Set<RoleDTO> roles,
                      CustomerDetailsDTO customerDetails) {}
