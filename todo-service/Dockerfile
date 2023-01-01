FROM openjdk:17-oracle
COPY ./target/todo-service-*.jar service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/service.jar"]