# syntax=docker/dockerfile:1
FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/rest-api.war .
RUN wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.58/bin/apache-tomcat-9.0.58.zip
RUN unzip apache-tomcat-9.0.58.zip -d .
CMD ["java", "rest-api.war"]
