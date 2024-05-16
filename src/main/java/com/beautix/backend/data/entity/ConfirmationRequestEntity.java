package com.beautix.backend.data.entity;

import com.beautix.backend.common.enums.ConfirmationRequestSubject;
import com.beautix.backend.common.enums.ConfirmationRequestType;
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

/**
 * Confirmation request entity.
 *
 * @author David Sapozhnik
 */
@Getter
@Setter
@Entity
@Table(name = "confirmation_request")
public class ConfirmationRequestEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false)
    private UserEntity user;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConfirmationRequestType type;

    @Column(name = "subject", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConfirmationRequestSubject subject;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "secret", nullable = false)
    private String secret;

    @Column(name = "confirmed", nullable = false)
    private boolean confirmed;

    @Column(name = "expired_at", nullable = false)
    private LocalDateTime expiredAt;
}
