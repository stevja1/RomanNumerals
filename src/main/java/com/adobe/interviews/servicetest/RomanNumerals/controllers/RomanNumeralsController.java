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

    public static String convertNumber(int number) {
        Map<Integer,String> map = new HashMap();
        map.put(1, "I");
//        map.put(5, "V");
        map.put(2, "X");
//        map.put(50, "L");
        map.put(3, "C");
//        map.put(500, "D");
        map.put(4, "M");

        int digit = 0;
        Stack<Integer> digits = new Stack();
        for(; number > 0; number = (int)Math.floor(number / 10)) {
            digit = number % 10;
            digits.push(digit);
        }

        while(digits.size() > 0) {
            System.out.print(digits.pop());
        }
        return "";
    }
}
