package com.backstreetbrogrammer.ch01_projectSetup;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.StringTemplate.STR;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTemplateTest {

    @Test
    @DisplayName("Test String Templates (Preview) [JEP-430]")
    void testStringTemplates() {
        final var java = "Java 21";
        final var comment = STR."\{java} is awesome";
        assertEquals("Java 21 is awesome", comment);
    }
}
