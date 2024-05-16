package com.beautix.backend.api.security;

import com.beautix.backend.api.util.RequestResponseLoggingUtil;
import com.beautix.backend.api.util.TokenUtil;
import com.beautix.backend.common.exceptions.CustomException;
import com.beautix.backend.common.exceptions.CustomExceptionBody;
import com.beautix.backend.core.model.session.SessionDTO;
import com.beautix.backend.core.service.session.SessionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static com.beautix.backend.api.util.RequestResponseLoggingUtil.prepareResponseLogMessage;
import static com.beautix.backend.api.util.TokenUtil.decodeToken;
import static com.beautix.backend.common.exceptions.ExceptionMessage.INTERNAL_SERVER_ERROR;
import static com.beautix.backend.common.exceptions.ExceptionMessage.UNAUTHORIZED;
import static jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static java.util.Objects.isNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Security filter
 *
 * @author David Sapozhnik
 */
@Log4j2
@Component
public class SecurityFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHORIZATION_SCHEMA = "bearer";

    @Autowired
    private SessionService sessionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) {

        var optionalToken = extractToken(request);
        if (optionalToken.isEmpty()) {
            logRequest(request);
            applyAuthenticationErrorResponse(response, UNAUTHORIZED.getException().getBody());
            logResponse(request, response);
            return;
        }
        try {
            var tokenAttributes = decodeToken(optionalToken.get());
            var session = sessionService.getSessionByID(tokenAttributes.sessionId());
            validateSession(session);
            var principal = prepareUserSessionPrincipal(session);
            SecurityContextHolder.getContext().setAuthentication(new SessionAuthentication(principal));
            logRequest(request, session.getUser().getId());
            filterChain.doFilter(request, response);
            logResponse(request, response);
        } catch (CustomException e) {
            logRequest(request);
            applyAuthenticationErrorResponse(response, e.getBody());
            logResponse(request, response);
        } catch (Exception e) {
            logRequest(request);
            log.error("Exception during SecurityFilter processing: ", e);
            applyAuthenticationErrorResponse(response, INTERNAL_SERVER_ERROR.getException().getBody());
            logResponse(request, response);
        }
    }

    /* Private methods */

    public static Optional<String> extractToken(HttpServletRequest request) {
        var header = request.getHeader(AUTHORIZATION_HEADER);
        if (isNull(header) || !header.toLowerCase().startsWith(AUTHORIZATION_SCHEMA)) {
            return Optional.empty();
        }
        return Optional.of(header.substring(AUTHORIZATION_SCHEMA.length()).trim());
    }

    private void validateSession(SessionDTO session) throws CustomException {
        //Temporary implementation
    }

    private UserSessionPrincipal prepareUserSessionPrincipal(SessionDTO session) {
        return new UserSessionPrincipal(session.getUser().getId(), session.getUser().getRole());
    }


    private void applyAuthenticationErrorResponse(HttpServletResponse httpResponse, CustomExceptionBody body) {
        try {
            httpResponse.setContentType(APPLICATION_JSON_VALUE);
            httpResponse.setStatus(SC_UNAUTHORIZED);
            httpResponse.getWriter().write(objectMapper.writeValueAsString(body));
            log.warn("Authentication error: {}", body.getMessage());
        } catch (IOException e) {
            log.error("Exception during Authentication error response preparation: ", e);
        }
    }

    private void logRequest(HttpServletRequest request) {
        log.info(RequestResponseLoggingUtil.prepareRequestLogMessage(request));
    }

    private void logRequest(HttpServletRequest request, Long userId) {
        log.info(RequestResponseLoggingUtil.prepareRequestLogMessage(request, userId));
    }

    private void logResponse(HttpServletRequest request, HttpServletResponse response) {
        log.info(prepareResponseLogMessage(request, response));
    }
}
