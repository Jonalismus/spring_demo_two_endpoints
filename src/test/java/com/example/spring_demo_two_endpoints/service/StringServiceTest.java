package com.example.spring_demo_two_endpoints.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringServiceTest {

    private StringService stringService;

    @BeforeEach
    void setUp() {
        stringService = new StringService();
    }

    @Test
    void testGetStringInfo_HelloWorld() {
        stringService.setStoredString("Hello World");
        StringInfo stringInfo = stringService.getStringInfo();

        assertEquals("Hello World", stringInfo.getStoredString());
    }

    @Test
    void testGetStringInfo_HelloWorldIsNumericOnlyFalse() {
        stringService.setStoredString("Hello World");
        StringInfo stringInfo = stringService.getStringInfo();

        assertFalse(stringInfo.isNumericOnly());
    }

    @Test
    void testGetStringInfo_OneWhitespace() {
        stringService.setStoredString("Hello World");
        StringInfo stringInfo = stringService.getStringInfo();

        assertEquals(2, stringInfo.getWhitespaceTupelsCount());
    }

    @Test
    void testIsNumericOnlyTrue() {
        assertTrue(stringService.isNumericOnly("12345"));
    }

    @Test
    void testIsNumericOnlyFalse() {
        assertFalse(stringService.isNumericOnly("12345abc"));
    }

    @Test
    void testIsNumericOnlyFalseWhenNull() {
        assertFalse(stringService.isNumericOnly(null));
    }

    @Test
    void testIsNumericOnlyFalseWhenNoChars() {
        assertFalse(stringService.isNumericOnly(""));
    }

    @Test
    void testCountWhitespaceTupels_LengthOfExampleSentence() {
        assertEquals(4, stringService.countWhitespaceTupels("4 für diesen Satz."));
    }

    @Test
    void testCountWhitespaceTupels_NoWhitesspace() {
        assertEquals(1, stringService.countWhitespaceTupels("12345"));
    }

    @Test
    void testCountWhitespaceTupels_NoContent() {
        assertEquals(0, stringService.countWhitespaceTupels(null));
    }

}