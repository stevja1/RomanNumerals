package com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvalidIndexExceptionTest {
    private static final ObjectMapper serializer = new ObjectMapper();
    @Test
    public void invalidIndexExceptionTest() throws JsonProcessingException {
        InvalidIndexException originalException = new InvalidIndexException("test message");
        String serialized = serializer.writeValueAsString(originalException);
        InvalidIndexException deserializedException = serializer.readValue(serialized, InvalidIndexException.class);
        assertEquals("test message", deserializedException.getMessage());
    }
}
