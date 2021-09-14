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
Run all tests:

```mvn clean test```

The lookup table used by this project has mappings for each significant Roman numeral. Since each significant numeral largely operates the same as the others, testing can be done on the unique sections of the map. Testing is also done to test boundries and out-of-bounds values.

Integration testing is also done against the service to check the `/romannumeral` and `/romannumeral/health` endpoints.

### Code Coverage
```mvn clean verify```

This will produce a raw binary `target/jacoco.exec` that can be ingested by something like Sonar. If you'd like to see the report in a human readable format, run:

```mvn jacoco:report```

This will produce .html files with the code coverage report that you can view in your browser. The root is located here: `target/site/jacoco/index.html`

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

## Service Dependencies
This service is self-contained and doesn't depend on any external databases or services.

## Code Dependency Attribution
Spring Initializr was used to stub out a basic web service.

REST API Capability:
* Spring Boot
* Spring Web
* Embedded Tomcat

Utilities:
* Slf4J/Log4J for logging
* Jackson for Serialization
* Lombok for simplifying some code
* Springfox's Swagger UI library to provide a swagger UI

For testing:
* JUnit
* Jacoco for code coverage reports

For metrics tracking:
* New Relic

## Monitoring and Alerting
This project leans heavily on New Relic for monitoring and alerting. The following "golden signals" can be monitored almost exclusively with New Relic. Alerts can be setup around these signals to alert someone via something like PagerDuty if there is an issue.

### Availability
This project includes a health check that can be called by a New Relic synthetic. An alert can be built around that synthetic.

### Responsiveness
This project's New Relic configuration includes apdex tracking in APM. An alert can be setup and thresholds configured around apdex to monitor application responsiveness.

### Error Rate
This project's New Relic configuration includes error rate tracking in APM. An alert can be setup and thresholds configured around error rate. 

### Capacity
Capacity monitoring can be accomplished in multiple ways:

#### Thread Tracking
Track and aggregate available container threads. Capacity can be reported as 'busy threads' / 'available threads'.

This project has JMX enabled and thread metrics are captured by New Relic. Alerts can be setup and thresholds configured around the number of busy threads.

#### CPU Utilization
Since this project is largely CPU bound, CPU utilization could be tracked as well, but it isn't ideal because it isn't a direct indicator of capacity/saturation.

In an environment like kubernetes, its easy to auto-scale based on cpu utilization. This ease of use may provide initial capacity management until something more mature can be put in place.

New Relic APM does track CPU utilization, but this can be misleading in a docker/kubernetes environment since CPU load in these environments is a reflection of the actual hardware and not the allocated resources for the individual node or container.