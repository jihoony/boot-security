package com.ksmartech.bootsecurity.controller;

import com.ksmartech.bootsecurity.cmn.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController extends BaseController {

    @RequestMapping({ "/hello" })
    public String firstPage() {

        logger.debug("hello");

        return "Hello World";
    }
}
