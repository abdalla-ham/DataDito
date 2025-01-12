<div align="center">

# Kafka Deployment

1. **Create Java Project** - *Local*
   
2. **Create Java Message Class** - *Local*

3. **Create Pull & Send Methods** - *Local*

4. **Deploy Kafka on Ubuntu 20.04 in GCP** - *Cloud*

5. **Convert Your Project to JAR File** - *Local*

6. **Show the Usage of the JAR File by giving it to the relevant services**

</div>

---

## About Apache Kafka

Apache Kafka is an open source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.

---

### Run the following commands in order to start all services in the correct order:


1. **Install Docker on your VM**
**```sudo apt-get update```**
**```sudo apt-get install apt-transport-https ca-certificates curl software-properties-common```**
**```curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -```**
**```sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"```**
**```sudo apt-get update```**
**```sudo apt-get install docker-ce```**
**```sudo systemctl start docker```**
**```sudo systemctl enable docker```**
**```sudo docker --version```**


2. **Install Docker Compose**
**```sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose```**
**```sudo chmod +x /usr/local/bin/docker-compose```**
**```sudo chmod +x /usr/local/bin/docker-compose```**
**```docker-compose --version```**

#### Once installed, complete the next steps.

3. **Create a Docker Compose File**
**```nano docker-compose.yml```**

**Paste this in your Compose File**
---
services:

  broker:
    image: confluentinc/cp-kafka:7.7.1
    hostname: broker
    container_name: broker
    ports:
      - "9092:9092"
      - "9101:9101"
    environment:
      KAFKA_NODE_ID: 1
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: 'CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT'
      KAFKA_ADVERTISED_LISTENERS: 'PLAINTEXT://broker:29092,PLAINTEXT_HOST://209.38.252.24:9092'
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS: 0
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1
      KAFKA_JMX_PORT: 9101
      KAFKA_JMX_HOSTNAME: 209.38.252.24
      KAFKA_PROCESS_ROLES: 'broker,controller'
      KAFKA_CONTROLLER_QUORUM_VOTERS: '1@broker:29093'
      KAFKA_LISTENERS: 'PLAINTEXT://broker:29092,CONTROLLER://broker:29093,PLAINTEXT_HOST://0.0.0.0:9092'
      KAFKA_INTER_BROKER_LISTENER_NAME: 'PLAINTEXT'
      KAFKA_CONTROLLER_LISTENER_NAMES: 'CONTROLLER'
      KAFKA_LOG_DIRS: '/tmp/kraft-combined-logs'
      CLUSTER_ID: 'MkU3OEVBNTcwNTJENDM2Qk'

  control-center:
    image: confluentinc/cp-enterprise-control-center:7.7.1
    hostname: control-center
    container_name: control-center
    depends_on:
      - broker
    ports:
      - "9021:9021"
    environment:
      CONTROL_CENTER_BOOTSTRAP_SERVERS: 'broker:29092'
      CONTROL_CENTER_CONNECT_CONNECT-DEFAULT_CLUSTER: 'connect:8083'
      CONTROL_CENTER_CONNECT_HEALTHCHECK_ENDPOINT: '/connectors'
      CONTROL_CENTER_REPLICATION_FACTOR: 1
      CONTROL_CENTER_INTERNAL_TOPICS_PARTITIONS: 1
      CONTROL_CENTER_MONITORING_INTERCEPTOR_TOPIC_PARTITIONS: 1
      CONFLUENT_METRICS_TOPIC_REPLICATION: 1
      PORT: 9021

**CTRL+O, ENTER, CTRL+X**

4. **Run Docker Compose**
**```sudo docker-compose up -d```**

### Once all services have successfully launched, you will have a basic Kafka environment running and ready to use. 
**Update Kafka.url="External-ip":9092**

