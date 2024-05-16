package com.beautix.backend.api.util;

import com.beautix.backend.api.security.TokenAttributes;
import com.beautix.backend.common.exceptions.CustomException;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.isNull;

/**
 * Token Util.
 *
 * @author David Sapozhnik
 */
public final class TokenUtil {

    private TokenUtil() {
    }

    public static TokenAttributes decodeToken(String token) throws CustomException {
        //Temporary implementation
        return new TokenAttributes(UUID.randomUUID(), LocalDateTime.now());
    }
}
