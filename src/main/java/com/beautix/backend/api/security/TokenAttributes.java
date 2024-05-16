package com.beautix.backend.api.security;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Token Attributes.
 *
 * @author David Spaozhnik
 */
public record TokenAttributes(UUID sessionId, LocalDateTime expiredAt) {
}
