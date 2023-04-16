FROM openjdk:19-alpine
ARG JAR_FILE=build/*.jar
COPY ./build/libs/URL_Shortener-0.0.1-SNAPSHOT.jar shortener.jar
ENTRYPOINT ["java", "-jar", "/shortener.jar"]