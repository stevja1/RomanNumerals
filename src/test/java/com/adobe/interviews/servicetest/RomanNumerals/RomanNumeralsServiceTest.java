package com.adobe.interviews.servicetest.RomanNumerals;

import com.adobe.interviews.servicetest.RomanNumerals.controllers.RomanNumeralsController;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RomanNumeralsServiceTest {
    @Test
    public void convertNumberTest() {
        // Test the full iteration of 1-10
        assertEquals("I", RomanNumeralsController.convertNumber(1));
        assertEquals("II", RomanNumeralsController.convertNumber(2));
        assertEquals("III", RomanNumeralsController.convertNumber(3));
        assertEquals("IV", RomanNumeralsController.convertNumber(4));
        assertEquals("V", RomanNumeralsController.convertNumber(5));
        assertEquals("VI", RomanNumeralsController.convertNumber(6));
        assertEquals("VII", RomanNumeralsController.convertNumber(7));
        assertEquals("VIII", RomanNumeralsController.convertNumber(8));
        assertEquals("IX", RomanNumeralsController.convertNumber(9));
        // Test the next digit in the map (2.1)
        assertEquals("X", RomanNumeralsController.convertNumber(10));
        assertEquals("XI", RomanNumeralsController.convertNumber(11));
        assertEquals("XII", RomanNumeralsController.convertNumber(12));
        assertEquals("XIII", RomanNumeralsController.convertNumber(13));
        assertEquals("XIV", RomanNumeralsController.convertNumber(14));
        assertEquals("XV", RomanNumeralsController.convertNumber(15));
        assertEquals("XVI", RomanNumeralsController.convertNumber(16));
        assertEquals("XVII", RomanNumeralsController.convertNumber(17));
        assertEquals("XVIII", RomanNumeralsController.convertNumber(18));
        assertEquals("XIX", RomanNumeralsController.convertNumber(19));
        assertEquals("XX", RomanNumeralsController.convertNumber(20));
        // Test limits
        assertEquals("MMMCMXCIX", RomanNumeralsController.convertNumber(3999));
        // Test out of bounds
        assertThrows(ArithmeticException.class, () -> RomanNumeralsController.convertNumber(-1));
        assertThrows(ArithmeticException.class, () -> RomanNumeralsController.convertNumber(0));
        assertThrows(ArithmeticException.class, () -> RomanNumeralsController.convertNumber(4000));
        assertThrows(ArithmeticException.class, () -> RomanNumeralsController.convertNumber(4001));
    }
}
