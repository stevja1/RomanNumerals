package com.adobe.interviews.servicetest.RomanNumerals.controllers;

import com.adobe.interviews.servicetest.RomanNumerals.services.RomanNumeralsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralsController {
    @GetMapping("/romannumeral")
    @Operation(
            summary = "Converts a provided decimal number into a Roman numeral."
    )
    public String getRomanNumerals(@RequestParam(value ="query", defaultValue="3999") int number) {
        return RomanNumeralsService.convertNumber(number);
    }
}
