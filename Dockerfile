FROM maven:3.8.5-openjdk-17 AS built
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=built /prank/72EmbaddedDB-0.0.1-SNAPSHOT.jar 72EmbaddedDB.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "72EmbaddedDB.jar"]