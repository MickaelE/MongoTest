FROM openjdk:11
WORKDIR usr/src
COPY ./pom.xml ./pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY ./src ./src
RUN ["chmod", "+x", "mvnw"]
RUN ./mvnw dependency:go-offline -B
RUN ./
ENTRYPOINT ["java","-jar", "otservice-0.0.1.jar"]
