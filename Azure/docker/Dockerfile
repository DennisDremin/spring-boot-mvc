FROM openjdk:11-jre-slim

COPY target/app-*.jar /app/app.jar

EXPOSE 8080
WORKDIR /app

CMD ["java", "-jar", "app.jar"]
