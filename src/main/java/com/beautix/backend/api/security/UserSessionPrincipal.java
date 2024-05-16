package com.beautix.backend.api.security;

import com.beautix.backend.common.enums.UserRole;

/**
 * User Session Model
 *
 * @author David Sapozhnik
 */
public record UserSessionPrincipal(Long id, UserRole role) {
}
