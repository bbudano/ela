FROM openjdk:17-oracle
COPY ./build/libs/ela-*.jar service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/service.jar"]