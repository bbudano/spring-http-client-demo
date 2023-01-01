FROM openjdk:17-oracle
COPY ./target/todo-client-*.jar client.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/client.jar"]