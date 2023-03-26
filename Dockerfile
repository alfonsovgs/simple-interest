FROM eclipse-temurin:17-jdk-alpine

ARG JAR_FILE=./target/microservice-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENV WEB-ALLOW-OTHERS=true

ENTRYPOINT ["java","-jar","/app.jar"]