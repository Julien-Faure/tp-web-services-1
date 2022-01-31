# syntax=docker/dockerfile:1
FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/soap-server.jar .
CMD ["java","jar", "soap-server.jar"]
