package com.adobe.interviews.servicetest.RomanNumerals;

import static org.junit.jupiter.api.Assertions.*;

import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.InvalidIndexException;
import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.RomanNumeralException;
import com.adobe.interviews.servicetest.RomanNumerals.services.RomanNumeralsService;
import org.junit.jupiter.api.Test;

public class RomanNumeralsServiceTest {
    @Test
    public void convertNumberTest() throws RomanNumeralException, InvalidIndexException {
        // Test combinations of digits that flex all lookups
        assertEquals("MMMCMXCIX", RomanNumeralsService.convertNumber(3999));
        assertEquals("MMDCCCLXXXVIII", RomanNumeralsService.convertNumber(2888));
        assertEquals("MDCCLXXVII", RomanNumeralsService.convertNumber(1777));
        assertEquals("M", RomanNumeralsService.convertNumber(1000));
        assertEquals("DCLXVI", RomanNumeralsService.convertNumber(666));
        assertEquals("DLV", RomanNumeralsService.convertNumber(555));
        assertEquals("CDXLIV", RomanNumeralsService.convertNumber(444));
        assertEquals("CCCXXXIII", RomanNumeralsService.convertNumber(333));
        assertEquals("CCXXII", RomanNumeralsService.convertNumber(222));
        assertEquals("CXI", RomanNumeralsService.convertNumber(111));
        assertEquals("X", RomanNumeralsService.convertNumber(10));

        // Test out of bounds
        assertThrows(RomanNumeralException.class, () -> RomanNumeralsService.convertNumber(-1));
        assertThrows(RomanNumeralException.class, () -> RomanNumeralsService.convertNumber(0));
        assertThrows(RomanNumeralException.class, () -> RomanNumeralsService.convertNumber(4000));
        assertThrows(RomanNumeralException.class, () -> RomanNumeralsService.convertNumber(4001));

        // Theoretically, the above tests should cover everything, however this line is easy to
        // write and is simple to understand.
        for(int i = 1; i < 4000; ++i) assertNotNull(RomanNumeralsService.convertNumber(i));
    }
}
