package com.beautix.backend.core.mapper;

import com.beautix.backend.core.model.session.SessionDTO;
import com.beautix.backend.data.entity.SessionEntity;

/**
 * Session mapper
 *
 * @author David Sapozhnik
 */
public final class SessionMapper {

    public static SessionDTO toDTO(SessionEntity entity) {
        if (entity == null) {
            return null;
        }

        SessionDTO dto = new SessionDTO();
        dto.setId(entity.getId());
        dto.setUser(UserMapper.toDTO(entity.getUser()));
        dto.setBrowserInfo(entity.getBrowserInfo());
        dto.setRevokeReason(entity.getRevokeReason());
        dto.setRevokedAt(entity.getRevokedAt());
        dto.setExpiredAt(entity.getExpiredAt());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}
