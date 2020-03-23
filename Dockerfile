# Start with a base image containing Java runtime
FROM java:openjdk-8-jdk

# Add a volume pointing to /tmp
VOLUME /tmp

# Add Maintainer Info
MAINTAINER Ahwin Oghenerukevwe <ahwinrukevwe@gmail.com>

# Make port 8080 available to the world outside this container
EXPOSE 8080

RUN echo "Etc/UTC" | tee /etc/timezone && dpkg-reconfigure --frontend noninteractive tzdata

# The application's jar file
ARG JAR_FILE=target/drone-real-time.jar

# Add the application's jar to the container
ADD ${JAR_FILE} drone-real-time.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/drone-real-time.jar"]
