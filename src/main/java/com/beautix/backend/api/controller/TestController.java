package com.beautix.backend.api.controller;

import com.beautix.backend.api.security.UserSessionPrincipal;
import com.beautix.backend.common.exceptions.CustomException;
import com.beautix.backend.common.exceptions.ExceptionMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David Sapozhnik
 */
@RestController
public class TestController {

    @GetMapping
    public String test(@AuthenticationPrincipal UserSessionPrincipal principal) throws Exception{

        return "test";
    }
}
