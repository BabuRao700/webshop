FROM openjdk:8-jdk-alpine
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
EXPOSE 8080
ADD target/product-service-0.0.1-SNAPSHOT.jar prodct-service.jar
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} prodct-service.jar

ENTRYPOINT ["sh", "-c", "java -jar /prodct-service.jar"]