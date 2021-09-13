package com.adobe.interviews.servicetest.RomanNumerals;

import static org.junit.jupiter.api.Assertions.*;

import com.adobe.interviews.servicetest.RomanNumerals.services.RomanNumeralsService;
import org.junit.jupiter.api.Test;

public class RomanNumeralsServiceTest {
    @Test
    public void convertNumberTest() {
        // Test the full iteration of 1-10
        assertEquals("I", RomanNumeralsService.convertNumber(1));
        assertEquals("II", RomanNumeralsService.convertNumber(2));
        assertEquals("III", RomanNumeralsService.convertNumber(3));
        assertEquals("IV", RomanNumeralsService.convertNumber(4));
        assertEquals("V", RomanNumeralsService.convertNumber(5));
        assertEquals("VI", RomanNumeralsService.convertNumber(6));
        assertEquals("VII", RomanNumeralsService.convertNumber(7));
        assertEquals("VIII", RomanNumeralsService.convertNumber(8));
        assertEquals("IX", RomanNumeralsService.convertNumber(9));
        // Test the next digit in the map (2.1)
        assertEquals("X", RomanNumeralsService.convertNumber(10));
        assertEquals("XI", RomanNumeralsService.convertNumber(11));
        assertEquals("XII", RomanNumeralsService.convertNumber(12));
        assertEquals("XIII", RomanNumeralsService.convertNumber(13));
        assertEquals("XIV", RomanNumeralsService.convertNumber(14));
        assertEquals("XV", RomanNumeralsService.convertNumber(15));
        assertEquals("XVI", RomanNumeralsService.convertNumber(16));
        assertEquals("XVII", RomanNumeralsService.convertNumber(17));
        assertEquals("XVIII", RomanNumeralsService.convertNumber(18));
        assertEquals("XIX", RomanNumeralsService.convertNumber(19));
        assertEquals("XX", RomanNumeralsService.convertNumber(20));
        // Test limits
        assertEquals("MMMCMXCIX", RomanNumeralsService.convertNumber(3999));
        // Test out of bounds
        assertThrows(ArithmeticException.class, () -> RomanNumeralsService.convertNumber(-1));
        assertThrows(ArithmeticException.class, () -> RomanNumeralsService.convertNumber(0));
        assertThrows(ArithmeticException.class, () -> RomanNumeralsService.convertNumber(4000));
        assertThrows(ArithmeticException.class, () -> RomanNumeralsService.convertNumber(4001));
    }
}
