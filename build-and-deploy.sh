#!/bin/bash

# Build the Spring project
./gradlew clean build -x test
./registerApi/gradlew clean build -x test

# Build Docker image and start services using Docker Compose
docker-compose -f docker-compose.yml up -d
