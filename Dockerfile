FROM openjdk:19-jdk-alpine3.16
ARG JAR_FILE=target/todolist-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]