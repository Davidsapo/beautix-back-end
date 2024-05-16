package com.beautix.backend.data.entity;

import com.beautix.backend.common.enums.UserRole;
import com.beautix.backend.common.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * User entity.
 *
 * @author David Sapozhnik
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "email_confirmed", nullable = false)
    private boolean emailConfirmed;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phone_confirmed", nullable = false)
    private boolean phoneConfirmed;

    @Column(name = "password")
    private String password;

    @Column(name = "removed_at")
    private LocalDateTime removedAt;
}
