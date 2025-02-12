FROM openjdk:22-jdk
WORKDIR /app
COPY . .
RUN ./mvnw package -DskipTests
RUN mv target/*.jar app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]
