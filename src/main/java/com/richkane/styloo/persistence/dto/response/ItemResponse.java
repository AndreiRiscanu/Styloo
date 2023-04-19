package com.richkane.styloo.persistence.dto.response;

public record ItemResponse(Long id,
                           String name,
                           Long quantity,
                           Float price,
                           String description) {}
