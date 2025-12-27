FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .

# use mvn instead of ./mvnw
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
ENV PORT=8082
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]
