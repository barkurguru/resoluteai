FROM openjdk:11

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/employee-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8090

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
