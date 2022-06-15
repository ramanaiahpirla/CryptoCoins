FROM ubuntu:20.04
FROM openjdk:11
ADD target/coinswitch.jar coinswitch.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "coinswitch.jar"]