package com.adobe.interviews.servicetest.RomanNumerals.controllers;

import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.InvalidIndexException;
import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.RomanNumeralError;
import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.RomanNumeralException;
import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.RomanNumeralResponse;
import com.adobe.interviews.servicetest.RomanNumerals.services.RomanNumeralsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class RomanNumeralsController {
    @GetMapping("/romannumeral")
    @Operation(
            summary = "Converts a provided decimal number into a Roman numeral."
    )
    public RomanNumeralResponse getRomanNumerals(@RequestParam(value ="query", defaultValue="3999") int number) throws RomanNumeralException, InvalidIndexException {
        return new RomanNumeralResponse(
            number,
            RomanNumeralsService.convertNumber(number)
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RomanNumeralException.class)
    public RomanNumeralError handleBadRequestException(HttpServletRequest req, Exception ex) {
        return new RomanNumeralError(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InvalidIndexException.class)
    public RomanNumeralError handleInvalidIndexException(HttpServletRequest req, Exception ex) {
        return new RomanNumeralError(ex.getMessage());
    }
}
