package com.beautix.backend.core.mapper;

import com.beautix.backend.core.model.UserDTO;
import com.beautix.backend.data.entity.UserEntity;

/**
 * User mapper
 *
 * @author David Sapozhnik
 */
public final class UserMapper {

    public static UserDTO toDTO(UserEntity user) {
        if (user == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setRole(user.getRole());
        dto.setStatus(user.getStatus());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setEmailConfirmed(user.isEmailConfirmed());
        dto.setPhone(user.getPhone());
        dto.setPhoneConfirmed(user.isPhoneConfirmed());
        dto.setRemovedAt(user.getRemovedAt());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }
}
