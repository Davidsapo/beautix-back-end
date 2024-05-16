package com.beautix.backend.core.service.session;

import com.beautix.backend.common.enums.UserRole;
import com.beautix.backend.common.exceptions.CustomException;
import com.beautix.backend.core.model.UserDTO;
import com.beautix.backend.core.model.session.SessionDTO;
import com.beautix.backend.data.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.beautix.backend.common.exceptions.ExceptionMessage.SESSION_NOT_FOUND;
import static com.beautix.backend.core.mapper.SessionMapper.toDTO;

/**
 * Session service
 *
 * @author David Sapozhnik
 */
@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Cacheable(cacheNames = "sessions", key = "#sessionID")
    public SessionDTO getSessionByID(UUID sessionID) throws CustomException {
        //return toDTO(sessionRepository.findById(sessionID).orElseThrow(SESSION_NOT_FOUND::getException));
        var user = new UserDTO();
        user.setId(1L);
        user.setRole(UserRole.GLOBAL_ADMIN);
        var session = new SessionDTO();
        session.setId(sessionID);
        session.setUser(user);
        return session;
    }
}
