package com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralExceptionTest {
    private static final ObjectMapper serializer = new ObjectMapper();
    @Test
    public void romanNumeralExceptionTest() throws JsonProcessingException {
        RomanNumeralException originalException = new RomanNumeralException("Test Message");
        String serialized = serializer.writeValueAsString(originalException);
        RomanNumeralException deserializedException = serializer.readValue(serialized, RomanNumeralException.class);
        assertEquals("Test Message", deserializedException.getMessage());
    }
}
