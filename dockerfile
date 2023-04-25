FROM maven as builder

COPY . /app

WORKDIR /app

RUN mvn install

FROM openjdk

ARG JAR_FILE=target/*.jar

COPY --from=builder /app/${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]