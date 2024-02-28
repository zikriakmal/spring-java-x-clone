# Use the official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven Wrapper files (if using Maven Wrapper)
COPY mvnw .
COPY .mvn .mvn

# Copy the project files and folders into the container
COPY src ./src
COPY pom.xml .

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port that the application will run on
EXPOSE 8088

# Specify the command to run on container startup
CMD ["java", "-jar", "target/twitter-0.0.1-SNAPSHOT.jar"]