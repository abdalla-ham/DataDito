FROM openjdk:23-jdk

WORKDIR /app

COPY out/artifacts/CGF_jar/CGF.jar /app/CGF.jar

COPY lib/Kafka.jar /app/lib/Kafka.jar

CMD ["java", "-cp", "/app/CGF.jar:/app/lib/Kafka.jar", "com.i2i.datadito.CGF.Main"]
