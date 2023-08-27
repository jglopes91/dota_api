FROM azul/zulu-openjdk-alpine:17-latest

WORKDIR /app

COPY build/libs/dotaApi-1.war dotaApi.war

CMD ["java", "-jar", "dotaApi.war"]