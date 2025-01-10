FROM amazoncorretto:23-alpine


RUN addgroup -S aomgroup && adduser -S aomuser -G aomgroup


WORKDIR /app


ARG JAR_FILE=./target/AOM-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/aom/jar/app.jar

RUN chown -R aomuser:aomgroup /app


RUN mkdir /logs && chown -R aomuser:aomgroup /logs && chmod -R 775 /logs


VOLUME /logs


EXPOSE 8080


USER aomuser

ENTRYPOINT ["java","-jar","/app/aom/jar/app.jar"]