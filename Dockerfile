FROM java:11
FROM maven:3.6.3-ibmjava-11-alpine

WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /code/src
RUN ["mvn", "install"]

EXPOSE 8080
CMD ["/usr/lib/jvm/java-11-openjdk-amd64/bin/java", "-jar", "target/comic-jar-with-dependencies.jar"]

