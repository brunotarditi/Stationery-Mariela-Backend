FROM openjdk:11-oracle
COPY ./target/store-0.0.1-SNAPSHOT.jar-0.0.1-SNAPSHOT.jar app/store.jar
CMD ["java", "-jar", "app/store.jar"]