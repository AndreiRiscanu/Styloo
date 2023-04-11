package com.richkane.styloo.persistence.dto.response;

public record ItemDTO(Long id,
                      String name,
                      Long quantity,
                      Float price,
                      String description) {}
