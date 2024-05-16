package com.beautix.backend.core.model;

import com.beautix.backend.common.enums.UserRole;
import com.beautix.backend.common.enums.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * User DTO
 *
 * @author David Sapozhnik
 */
@Getter
@Setter
public class UserDTO extends CommonDTO {

    private UserRole role;
    private UserStatus status;
    private String fullName;
    private String email;
    private boolean emailConfirmed;
    private String phone;
    private boolean phoneConfirmed;
    private LocalDateTime removedAt;
}
