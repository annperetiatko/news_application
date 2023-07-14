FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/news_project-0.0.1-SNAPSHOT.jar news_project.jar
EXPOSE 8088
ENTRYPOINT [ "java", "-jar", "news_project.jar" ]