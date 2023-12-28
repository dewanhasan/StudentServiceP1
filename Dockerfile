FROM openjdk:19-jdk-slim

WORKDIR /app

COPY target/StudentService-0.0.1-SNAPSHOT.jar /app

EXPOSE 8081

CMD ["java", "-jar", "StudentService-0.0.1-SNAPSHOT.jar"]