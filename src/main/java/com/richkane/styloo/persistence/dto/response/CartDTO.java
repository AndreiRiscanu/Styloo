package com.richkane.styloo.persistence.dto.response;

import java.util.Set;

public record CartDTO(Float total,
                      UserDTO user,
                      Set<ItemDTO> items) {}
