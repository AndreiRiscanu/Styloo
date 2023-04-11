package com.richkane.styloo.persistence.dto.response;

import java.util.Set;

public record CartDTO(Long id,
                      Float total,
                      UserDTO user,
                      Set<ItemDTO> items) {}
