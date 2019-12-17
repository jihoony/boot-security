package com.ksmartech.bootsecurity.cmn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public abstract class BaseComponent {
    protected Logger logger;

    @PostConstruct
    protected void init(){
        logger.info(this.getClass().getSimpleName() + ".init()");
    }

    protected BaseComponent() {
        logger = LoggerFactory.getLogger(this.getClass());
        logger.debug(this.getClass().getName() + " Constructor");
    }
}
