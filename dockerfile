# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and necessary files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Make Gradle wrapper executable
RUN chmod +x gradlew

# Copy the rest of the application code
COPY src src

# Run Gradle build (now with all source code included)
RUN ./gradlew build -x test --no-daemon --stacktrace --info

# Expose the port your application runs on (default is 8095 as per your Swagger URL)
EXPOSE 8095

# Define the entry point for the container to use the JAR
ENTRYPOINT ["java", "-jar", "build/libs/ecommspring.jar"]
