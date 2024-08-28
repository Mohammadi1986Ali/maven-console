package com.ai4everyone.tutorial.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private static final Properties PROPERTIES = new Properties();

    @BeforeAll
    public static void setup() {
        LOGGER.info("Setting test environment");
        try (InputStream resource = Application.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(resource);
        } catch (IOException e) {
            LOGGER.info("Error loading application properties", e);
        }
    }

    @Test
    void givenApplicationProperties_whenGettingProjectVersion_thenItMustEqualToArtifactVersion() {
        LOGGER.info("Project version: {}", PROPERTIES.getProperty("project.version"));
        assertEquals("1.0.1",
                PROPERTIES.getProperty("project.version"),
                "Project version should be equal to 1.0.1");
    }
}