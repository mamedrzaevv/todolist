FROM openjdk:22-jdk
WORKDIR /todolist
COPY . .
RUN ./mvnw package -DskipTests
RUN mv target/*.jar todolist.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]
