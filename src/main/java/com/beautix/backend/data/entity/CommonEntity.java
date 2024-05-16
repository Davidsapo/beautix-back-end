package com.beautix.backend.data.entity;

import jakarta.persistence.Column;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Common entity.
 *
 * @author David Sapozhnik
 */
@Getter
public abstract class CommonEntity {

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
}
