package com.richkane.styloo.persistence.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.richkane.styloo.persistence.GenderEnum;
import com.richkane.styloo.persistence.model.Cart;

import java.time.LocalDate;
import java.util.Set;

public record UserDTO(String firstName,
                      String lastName,
                      String email,
                      String phoneNumber,
                      @JsonFormat(pattern="dd-MM-yyyy") LocalDate birthDay,
                      GenderEnum gender,
                      Set<RoleDTO> roles,
                      Cart cart) {}
