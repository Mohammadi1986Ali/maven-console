package com.nexora.software.app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {
    private static final Logger log = LoggerFactory.getLogger(ApplicationTest.class);
    private static final Properties PROPERTIES = new Properties();

    @BeforeAll
    public static void setup() {
        log.info("Setting test environment");
        try (InputStream resource = Application.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(resource);
        } catch (IOException e) {
            log.info("Error loading application properties", e);
        }
    }

    @Test
    void givenApplicationProperties_whenGettingProjectVersion_thenItMustEqualToArtifactVersion() {
        log.info("Project version: {}", PROPERTIES.getProperty("project.version"));
        assertEquals("1.0.1",
                PROPERTIES.getProperty("project.version"),
                "Project version should be equal to 1.0.1");
    }
}