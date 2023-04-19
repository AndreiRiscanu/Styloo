package com.richkane.styloo.persistence.dto.response;

import java.util.Set;

public record UserResponse(String email,
                           Set<RoleResponse> roles,
                           CustomerDetailsResponse customerDetails) {}
