FROM openjdk:8-jdk-alpine
VOLUME /tmp
MAINTAINER albertowas12@hotmail.com
ADD target/clean-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]