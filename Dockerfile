FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9094
ENTRYPOINT ["java", "-jar", "app.jar"]