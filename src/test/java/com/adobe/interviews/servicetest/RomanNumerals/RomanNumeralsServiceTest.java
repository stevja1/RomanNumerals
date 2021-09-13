package com.adobe.interviews.servicetest.RomanNumerals;

import com.adobe.interviews.servicetest.RomanNumerals.controllers.RomanNumeralsController;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class RomanNumeralsServiceTest {
    @Test
    public void convertNumberTest() {
        RomanNumeralsController.convertNumber(123); // CXXIII
        RomanNumeralsController.convertNumber(492); // CDXCII
    }
}
