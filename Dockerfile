FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/airport-spring-boot-docker_webapp-0.1.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
