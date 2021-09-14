package com.adobe.interviews.servicetest.RomanNumerals.controllers;

import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.InvalidIndexException;
import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.RomanNumeralError;
import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.RomanNumeralException;
import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.RomanNumeralResponse;
import com.adobe.interviews.servicetest.RomanNumerals.services.RomanNumeralsService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class RomanNumeralsController {
    @GetMapping(value = "/romannumeral", produces = "application/json")
    @Operation(
            summary = "Converts a provided decimal number into a Roman numeral."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request was processed successfully", response = RomanNumeralResponse.class),
            @ApiResponse(code = 400, message = "Invalid input was provided", response = RomanNumeralError.class),
            @ApiResponse(code = 500, message = "An internal error occurred", response = RomanNumeralError.class)
    })
    public RomanNumeralResponse getRomanNumerals(@RequestParam(value ="query", defaultValue="3999") int number) throws RomanNumeralException, InvalidIndexException {
        return new RomanNumeralResponse(
            number,
            RomanNumeralsService.convertNumber(number)
        );
    }

    @GetMapping("/romannumeral/health")
    @Operation(
            summary = "Returns the health status of this API."
    )
    public String getHealth() {
        /*
           Ordinarily, there would be something here that would test dependencies (i.e., databases,
           queues, other microservices, etc). Since this service has none, we're basically just
           verifying that the container is up and running.
         */
        return "Healthy";
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
