package com.beautix.backend.data.entity;

import com.beautix.backend.common.enums.SessionRevokeReason;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Session entity.
 *
 * @author David Sapozhnik
 */
@Getter
@Setter
@Entity
@Table(name = "session")
public class SessionEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false)
    private UserEntity user;

    @Column(name = "browser_info")
    private String browserInfo;

    @Column(name = "revoke_reason")
    @Enumerated(EnumType.STRING)
    private SessionRevokeReason revokeReason;

    @Column(name = "revoked_at")
    private LocalDateTime revokedAt;

    @Column(name = "expired_at", nullable = false)
    private LocalDateTime expiredAt;
}
