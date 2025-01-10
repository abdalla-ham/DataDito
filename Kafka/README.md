<div align="center">

# Kafka Steps

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

Follow the steps below to set up Apache Kafka Server in the Cloud on GCP. Deploy using the public image available in the marketplaces.

### Link to Kafka on GCP:
[Kafka on GCP - Marketplace](https://console.cloud.google.com/marketplace/product/cloud-infrastructure-services/kafka-ubuntu?inv=1&invt=Abmd0A&project=metal-pod-435218-m3)

Once connected and logged in, the following section explains how to start using Kafka.

---

## Start the Kafka Environment

Run the following commands in order to start all services in the correct order:


**Change current path to Kafka installation directory**
**```cd /opt/kafka/```**

**Start the ZooKeeper service**
**```sudo bin/zookeeper-server-start.sh config/zookeeper.properties```**

# Open another terminal session to complete the next steps.

**Change current path to Kafka installation directory again**
**```cd /opt/kafka/```**

**Start the Kafka broker service**
**```sudo bin/kafka-server-start.sh config/server.properties```**

# Once all services have successfully launched, you will have a basic Kafka environment running and ready to use.

