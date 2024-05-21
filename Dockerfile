FROM eclipse-temurin:22-jdk-alpine

VOLUME /tmp

COPY target/Spring_Demo_Two_Endpoints-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
