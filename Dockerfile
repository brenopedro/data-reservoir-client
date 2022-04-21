FROM openjdk:11-jre-slim

WORKDIR /app

ARG JAR_FILE

COPY target/${JAR_FILE} /app/client.jar

EXPOSE 8082

CMD ["java", "-jar", "client.jar"]