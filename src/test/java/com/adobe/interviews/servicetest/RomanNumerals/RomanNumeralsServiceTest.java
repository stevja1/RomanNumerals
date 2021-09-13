package com.adobe.interviews.servicetest.RomanNumerals;

import com.adobe.interviews.servicetest.RomanNumerals.controllers.RomanNumeralsController;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RomanNumeralsServiceTest {
    @Test
    public void convertNumberTest() {
        assertEquals("I", RomanNumeralsController.convertNumber(1));
        assertEquals("II", RomanNumeralsController.convertNumber(2));
        assertEquals("III", RomanNumeralsController.convertNumber(3));
        assertEquals("IV", RomanNumeralsController.convertNumber(4));
        assertEquals("V", RomanNumeralsController.convertNumber(5));
        assertEquals("VI", RomanNumeralsController.convertNumber(6));
        assertEquals("VII", RomanNumeralsController.convertNumber(7));
        assertEquals("VIII", RomanNumeralsController.convertNumber(8));
        assertEquals("IX", RomanNumeralsController.convertNumber(9));
        assertEquals("X", RomanNumeralsController.convertNumber(10));
        assertEquals("CXXIII", RomanNumeralsController.convertNumber(123));
        assertEquals("CDXCII", RomanNumeralsController.convertNumber(492));
    }
}
