# ---------- Stage 1: Build Stage ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy all project files
COPY . .

# Build jar file
RUN mvn clean package -DskipTests


# ---------- Stage 2: Runtime Stage ----------
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]
