package com.adobe.interviews.servicetest.RomanNumerals.controllers;

import io.swagger.annotations.SwaggerDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RomanNumeralsController {
    @GetMapping("/romannumerals")
    @Operation(
            summary = "Converts a provided decimal number into a Roman numeral."
    )
    public String getRomanNumerals(@RequestParam(value ="Input decimal number", defaultValue="1000") int number) {
        return "";
    }

    /**
     * Convert a decimal to Roman numeral. Can be used for numbers above zero and below 3999.
     * @param number The number to convert
     * @return The Roman numeral representation of the number
     * @throws ArithmeticException Thrown if the number provided is below 1 or greater than 3999
     */
    public static String convertNumber(int number) throws ArithmeticException {
        if(number < 1 || number > 3999) {
            throw new ArithmeticException("Number "+number+" is out of bounds. Number must be above 0 and below 4000.");
        }

        Map<String,String> map = new HashMap();
        map.put("1", "I");
        map.put("1.5", "V");
        map.put("2", "X");
//        map.put(50, "L");
        map.put("3.1", "C");
        map.put("3.2", "CC");
        map.put("3.3", "CCC");
        map.put("3.4", "CD");
        map.put("3.5", "D");
        map.put("3.6", "DC");
        map.put("3.7", "DCC");
        map.put("3.8", "DCCC");
        map.put("3.9", "CM");
        map.put("4", "M");

        int digit = 0;
        Stack<Integer> digits = new Stack();
        for(; number > 0; number = (int)Math.floor(number / 10)) {
            digit = number % 10;
            digits.push(digit);
        }

        int index = digits.size();
        while(digits.size() > 0) {
            digit = digits.pop();
            if(digit < 4) {

            }
            --index;
        }
        return "";
    }
}
