package com.richkane.styloo.persistence.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.richkane.styloo.persistence.GenderEnum;

import java.time.LocalDate;

public record UserDTO(String firstName,
                      String lastName,
                      String email,
                      String phoneNumber,
                      @JsonFormat(pattern="dd-MM-yyyy") LocalDate birthDay,
                      GenderEnum gender) {}
