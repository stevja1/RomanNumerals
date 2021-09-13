# RomanNumerals
A service for converting decimal numbers to roman numerals.

This converter uses a lookup table to find appropriate Roman numeral digits. This was done to simplify development and scalability of the converter. As support for higher numbers is needed, additional Roman numeral information can be simply added to the lookup table.

## Building
```mvn clean package```

## Running
```mvn spring-boot:run```

## Swagger
http://localhost:8080/swagger-ui/#/

## Testing
```mvn clean test```

The lookup table used by this project has mappings for each significant Roman numeral. Since each significant numeral largely operates the same as the others, testing can be done on the unique sections of the map. Testing is also done to test boundries and out-of-bounds values.

## Layout
Code for this project is in a single module called RomanNumerals and follows the standard maven/java code layout.

* Code is contained in the `src/main/java` directory.
* Tests are contained in the `src/test/java` directory.
* Properties are contained in the `src/main/resources` directory.
* Compiled classes are contained in the `target` directory.

## Deployment
To containerize the application, run:
`docker build -t roman_numerals_test .`

The container this produces can then be deployed/run:
`docker run -p 8080:8080 -e NEW_RELIC_LICENSE_KEY=[LICENSE KEY] roman_numerals_test`

The `NEW_RELIC_LICENSE_KEY` secret should be injected at deployment-time.

### Enable New Relic
Obtain a New Relic license key. When running the docker container, set the `NEW_RELIC_LICENSE_KEY` environment variable.

New Relic logs are located in `monitoring/newrelic/logs/newrelic_agent.log`.

## Dependency Attribution
Spring Initializr was used to stub out a basic web service.

REST API Capability:
* Spring Boot
* Spring Web
* Embedded Tomcat

Utilities:
* Slf4J/Log4J for logging
* Lombok for simplifying some code
* Springfox's Swagger UI library to provide a swagger UI

For testing:
* JUnit

For metrics tracking:
* New Relic

> NOTE: For a full list of dependencies, see the pom.xml.

# To Do:
* Integration testing?
* Remove boiler-plate endpoints
* Add health check
* Add section in README.md about remote monitoring and alerts
* Set logging to ERROR only