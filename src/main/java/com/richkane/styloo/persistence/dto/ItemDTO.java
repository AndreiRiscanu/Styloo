package com.richkane.styloo.persistence.dto;

public record ItemDTO(Long id,
                      String name,
                      Long quantity,
                      Float price,
                      String description) {}
