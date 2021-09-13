package com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos;

import lombok.RequiredArgsConstructor;

public class InvalidIndexException extends Exception {
    public InvalidIndexException(String message) {
        super(message);
    }
}
