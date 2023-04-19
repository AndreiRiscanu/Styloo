package com.richkane.styloo.persistence.dto.response;

import java.util.Set;

public record CartResponse(Float total,
                           UserResponse user,
                           Set<ItemResponse> items) {}
