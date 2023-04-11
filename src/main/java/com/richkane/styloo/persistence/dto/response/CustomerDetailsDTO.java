package com.richkane.styloo.persistence.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.richkane.styloo.persistence.GenderEnum;

import java.time.LocalDate;

public record CustomerDetailsDTO(String firstName,
                                 String lastName,
                                 String phoneNumber,
                                 @JsonFormat(pattern="dd-MM-yyyy") LocalDate birthDay,
                                 GenderEnum gender,
                                 CartDTO cart) {
}
