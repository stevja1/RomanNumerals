package com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralResponseTest {
    private static final ObjectMapper serializer = new ObjectMapper();
    @Test
    public void romanNumeralResponseTest() throws JsonProcessingException {
        RomanNumeralResponse originalResponse = new RomanNumeralResponse(5, "V");
        String serialized = serializer.writeValueAsString(originalResponse);
        RomanNumeralResponse deserializedResponse = serializer.readValue(serialized, RomanNumeralResponse.class);
        assertEquals(5, deserializedResponse.getInput());
        assertEquals("V", deserializedResponse.getOutput());
    }
}
