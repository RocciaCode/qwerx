# === Build Stage ===
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom and download dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the source
COPY src ./src

# Build the Spring Boot app
RUN mvn clean package -DskipTests

# === Runtime Stage ===
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy built JAR
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
