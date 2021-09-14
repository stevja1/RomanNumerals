package com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralErrorTest {
    private static final ObjectMapper serializer = new ObjectMapper();

    @Test
    public void romanNumeralErrorTest() throws JsonProcessingException {
        RomanNumeralError originalError = new RomanNumeralError("Test Error Message");
        String serialized = serializer.writeValueAsString(originalError);
        RomanNumeralError deserializedError = serializer.readValue(serialized, RomanNumeralError.class);
        assertEquals("Test Error Message", deserializedError.getError());
    }
}
