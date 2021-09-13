FROM openjdk:11-jdk-slim
RUN addgroup --system spring && adduser --system --group spring
USER spring:spring
ARG JAR_FILE=target/RomanNumerals-*.jar
COPY ${JAR_FILE} app.jar
ADD --chown=spring:spring monitoring /monitoring
ENTRYPOINT ["java","-javaagent:monitoring/newrelic/newrelic.jar","-Dnewrelic.config.file=monitoring/newrelic/newrelic.yml","-jar","/app.jar"]
