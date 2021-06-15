FROM openjdk:8
EXPOSE 8080
ADD flights.jar flights.jar
ADD flights.csv flights.csv
ENTRYPOINT ["java", "-jar", "flights.jar"]