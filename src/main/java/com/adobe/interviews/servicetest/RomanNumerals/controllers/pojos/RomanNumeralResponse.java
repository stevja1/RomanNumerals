package com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RomanNumeralResponse {
    private int input;
    private String output;
}
