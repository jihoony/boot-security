package com.ksmartech.bootsecurity.controller;

import com.ksmartech.bootsecurity.cmn.BaseController;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController extends BaseController {

    @RequestMapping({ "/hello" })
    public String firstPage(Authentication authentication) {
        String currentPrincipalName = authentication.getName();

        logger.debug("hello: [" + currentPrincipalName + "]");

        return "Hello World";
    }
}
