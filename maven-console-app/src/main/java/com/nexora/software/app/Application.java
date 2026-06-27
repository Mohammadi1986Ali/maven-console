package com.nexora.software.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        log.info("Application#main");
        log.info("INFO");
        log.debug("DEBUG");
    }
}
