FROM azul/zulu-openjdk-alpine:17-latest

WORKDIR /app

COPY build/libs/register-1.jar app.jar

CMD ["java", "-jar", "app.jar"]