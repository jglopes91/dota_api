# Dota Hero API

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1-6DB33F?logo=springboot&logoColor=white)
![OpenDota](https://img.shields.io/badge/data%20source-OpenDota-2F6FEB)
![Docker Compose](https://img.shields.io/badge/containerized-Docker%20Compose-2496ED?logo=docker&logoColor=white)

A Spring Boot application that consumes the [OpenDota API](https://docs.opendota.com/) to retrieve Dota heroes and exposes a clean, documented REST interface. The project also demonstrates user registration through an asynchronous Kafka workflow, persistence with MySQL, response caching, ETags, and API rate limiting with Kong.

## Features

- Retrieve the complete list of Dota heroes.
- Filter heroes by name.
- Cache external hero data to reduce repeated calls.
- Add ETag support for conditional HTTP requests.
- Persist registered users in MySQL.
- Publish registration events to Kafka.
- Apply gateway rate limiting with Kong.
- Explore the API through generated OpenAPI/Swagger documentation.

## Architecture

```text
Client ──> Kong Gateway ──> Dota API:8081 ──> OpenDota
                              │
                              ├──> MySQL
                              └──> Kafka <── Register API:8082
```

## Technology stack

| Area | Technology |
| --- | --- |
| Language and framework | Java 17, Spring Boot |
| Persistence | Spring Data JPA, MySQL 8 |
| Messaging | Apache Kafka, ZooKeeper, Spring Kafka |
| Gateway | Kong |
| API documentation | Springdoc OpenAPI |
| Build and runtime | Gradle, Docker Compose |

## Prerequisites

- Java 17 or later
- Docker and Docker Compose
- Internet access for the OpenDota integration

## Running locally

Build the applications and start the supporting services:

```bash
chmod +x build-and-deploy.sh
./build-and-deploy.sh
```

The script builds both Gradle applications and starts the Docker Compose stack. The compose file starts Kong, MySQL, ZooKeeper, Kafka, the main Dota API, and the registration API.

## API reference

Once the stack is running, the main API is available through Kong at `http://localhost:8080`.

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/heroes` | Return all heroes |
| `GET` | `/heroes/{heroName}` | Find heroes whose name matches the path value |
| `GET` | `/health` | Check service health |
| `POST` | `/register` | Register a user and publish the registration event |

Swagger UI:

- Main API: [http://localhost:8080/principal/swagger-ui/index.html](http://localhost:8080/principal/swagger-ui/index.html)
- Registration API: [http://localhost:8080/register/swagger-ui/index.html](http://localhost:8080/register/swagger-ui/index.html)

## Example requests

```bash
curl http://localhost:8080/principal/heroes
curl http://localhost:8080/principal/heroes/Invoker
curl http://localhost:8080/principal/health
```

The exact request body for registration is documented in the Registration API Swagger UI.

## Project structure

```text
src/                              Main Dota API
registerApi/                      Registration and event producer service
kong_config/                      Kong declarative configuration
docker-compose.yml                Local infrastructure and services
build-and-deploy.sh               Build and startup script
```

## Notes

This repository is a technical demonstration and uses development credentials and single-node infrastructure in its local Compose configuration. Review and replace those settings before deploying to a shared or production environment.

## Author

João Gabriel Lopes — [@jglopes91](https://github.com/jglopes91)