# About CGF

CGF essentially listens to Kafka and sends the information to Oracle for storage.

# Progress / Plan

## General Execution with Dependencies

- Kafka Consumer Client should be set up to receive messages
  - Use com.datadito.kafka.message.UsageRecordMessage for the subscriber
- JSON processing may be necessary. Jackson could be utilized.
- Oracle JDBC driver should be used for connecting to Oracle DB
- Connection pooling via HikariCP
- Logging via SLF4J

## Docker
- Dockerfile should be made

## Classes 
- ConfigLoader.java
  - Loads properties from the application properties
  - Allows env variable overriding
  - Acts as a neat access point for config values
- DataSourceConfig.java
  - Connection pool via HikariCP
  - DB credentials from ConfigLoader
  - Single central reusable datasource
- OracleCRUD.java
  - Deal with Oracle db interactions
  - Take UsageRecordMessage as input and sends to Oracle, logging success/failure appropriately
- Main.java
  - Entrypoint
  - Initializes Kafka subscriber for UsageRecordMessage in an infinite loop 
- MainTest.java
  - Tests Main CGF function
