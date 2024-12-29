# Step 1: Use a Java base image
FROM openjdk:21-jdk-slim as build

# Step 2: Set the working directory
WORKDIR /app

# Step 3: Copy the pom.xml and install dependencies (maven clean install)
COPY pom.xml .

# Run maven to fetch dependencies
RUN mvn dependency:go-offline

# Step 4: Copy the entire source code
COPY src /app/src

# Step 5: Build the application
RUN mvn clean package -DskipTests

# Step 6: Create the final image using a smaller base image
FROM openjdk:21-jre-slim

# Step 7: Set the working directory
WORKDIR /app

# Step 8: Copy the JAR file from the build stage
COPY --from=build /app/target/web-application-0.0.1-SNAPSHOT.jar /app/app.jar

# Step 9: Expose the port the app will run on (default Spring Boot port is 8080)
EXPOSE 8080

# Step 10: Define the command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]