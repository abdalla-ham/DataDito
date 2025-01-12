FROM openjdk:23-jdk

WORKDIR /app

COPY out/artifacts/ABMF_jar/ABMF.jar /app/ABMF.jar

COPY lib/Kafka.jar /app/lib/Kafka.jar

CMD ["java", "-cp", "/app/ABMF.jar:/app/lib/Kafka.jar", "com.i2i.datadito.ABMF.ABMF"]