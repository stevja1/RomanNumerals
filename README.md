# RomanNumerals
A service for converting decimal numbers to roman numerals.

This converter uses a lookup table to find appropriate Roman numeral digits. This was done to simplify development and scalability of the converter. As support for higher numbers is needed, additional Roman numeral information can be simply added to the lookup table.

## Swagger
http://localhost:8080/swagger-ui/#/

## Building
```mvn clean package```

## Running
```mvn spring-boot:run```

## Testing
```mvn clean test```

The lookup table used by this project has a section for each significant digit. Since each significant digit largely operates the same as the others, testing can be done on the unique sections of the map. Testing is also done to test for out-of-bounds queries as well as extreme values.

## Layout
Code for this project is in a single module - RomanNumerals and follows the standard maven/java code layout.

Code is contained in the `src/main/java` directory.
Tests are contained in the `src/test/java` directory.
Properties are contained in the `src/main/resources` directory.

## Deployment

## Dependencies

## Todo
* Fix output to match specifications in requirements doc
* Fix error handling so that useful errors are returned to the user
* Dockerize the project
* Include kubernetes deployment manifests
* Include New Relic synthetic Javascript
* Improve logging
* Document deployment information
* Document dependencies (new relic, logging, spring boot/spring initializr, etc)
