package com.adobe.interviews.servicetest.RomanNumerals;

import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.RomanNumeralError;
import com.adobe.interviews.servicetest.RomanNumerals.controllers.pojos.RomanNumeralResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RomanNumeralsApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testRomanNumeral() {
		RomanNumeralResponse response = this.restTemplate.getForObject("/romannumeral?query=3888", RomanNumeralResponse.class);
		assertEquals(3888, response.getInput());
		assertEquals("MMMDCCCLXXXVIII", response.getOutput());
	}

	@Test
	void testRomanNumeralInvalid() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<RomanNumeralResponse> entity = new HttpEntity<>(headers);
		ResponseEntity<RomanNumeralError> response = this.restTemplate.exchange("/romannumeral?query=4000", HttpMethod.GET, entity, RomanNumeralError.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Number 4000 isn't supported. Number must be above 0 and below 4000.", response.getBody().getError());
	}

	@Test
	void testHealth() {
		String response = this.restTemplate.getForObject("/romannumeral/health", String.class);
		assertEquals("Healthy", response);
	}
}
