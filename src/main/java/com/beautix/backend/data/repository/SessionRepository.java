package com.beautix.backend.data.repository;

import com.beautix.backend.data.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Session Repository
 *
 * @author David Sapozhnik
 */
@Repository
public interface SessionRepository extends JpaRepository<SessionEntity, UUID> {
}
