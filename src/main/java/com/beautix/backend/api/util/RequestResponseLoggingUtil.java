package com.beautix.backend.api.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.slf4j.MDC;

import java.util.UUID;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Request Response Logging Util.
 *
 * @author David Sapozhnik
 */
@Log4j2
public final class RequestResponseLoggingUtil {

    public static final String REQUEST_ID_HEADER = "Request_id";
    public static final String REQUEST_ID_ITEM = "requestId";

    public static String prepareRequestLogMessage(HttpServletRequest request) {
        return prepareRequestLogMessage(request, null);
    }

    public static String prepareRequestLogMessage(HttpServletRequest request, Long userId) {
        setRequestId(request);
        var message = "Request  | " + getMethodAndQueryString(request);
        return nonNull(userId) ? message + " | userId - " + userId : message;
    }

    public static String prepareResponseLogMessage(HttpServletRequest request, HttpServletResponse response) {
        return "Response | " + getMethodAndQueryString(request) + " | " + response.getStatus();
    }

    /* Private methods */

    private static void setRequestId(HttpServletRequest request) {
        var header = request.getHeader(REQUEST_ID_HEADER);
        if (isNull(header)) {
            header = UUID.randomUUID().toString();
        }
        MDC.put(REQUEST_ID_ITEM, header);
    }

    private static String getMethodAndQueryString(HttpServletRequest request) {
        var result = request.getMethod() + " | " + request.getRequestURI();
        if (request.getQueryString() != null && !request.getQueryString().isEmpty()) {
            result = result + "?" + request.getQueryString();
        }
        return result;
    }
}
