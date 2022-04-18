FROM openjdk:11
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN ./gradlew build
ENTRYPOINT ./gradlew :server:run