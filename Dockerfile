#FROM java:8 
#FROM maven:3.6.3-ibmjava-8-alpine

#WORKDIR /code

# Prepare by downloading dependencies
#ADD pom.xml /code/pom.xml
#RUN ["mvn", "dependency:resolve"]
#RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
#ADD src /code/src
#RUN ["mvn", "install"]

#EXPOSE 8080
#CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "target/comic-jar-with-dependencies.jar"]


# Use the official maven/Java 8 image to create a build artifact.
# https://hub.docker.com/_/maven
FROM maven:3.6-jdk-8 as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package -DskipTests

# Use AdoptOpenJDK for base image.
# It's important to use OpenJDK 8u191 or above that has container support enabled.
# https://hub.docker.com/r/adoptopenjdk/openjdk8
# https://docs.docker.com/develop/develop-images/multistage-build/#use-multi-stage-builds
FROM adoptopenjdk/openjdk8:alpine-slim

# Copy the jar to the production image from the builder stage.
COPY --from=builder /app/target/comic-*.jar /helloworld.jar

# Run the web service on container startup.
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/helloworld.jar"]

