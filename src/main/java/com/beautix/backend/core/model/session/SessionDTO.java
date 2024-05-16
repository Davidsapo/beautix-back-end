package com.beautix.backend.core.model.session;

import com.beautix.backend.common.enums.SessionRevokeReason;
import com.beautix.backend.core.model.UserDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Session DTO
 *
 * @author David Sapozhnik
 */
@Getter
@Setter
public class SessionDTO {

    private UUID id;
    private UserDTO user;
    private String browserInfo;
    private SessionRevokeReason revokeReason;
    private LocalDateTime revokedAt;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;
}
