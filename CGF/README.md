# About CGF

CGF essentially listens to Kafka and sends the information to Oracle for storage.

# Code Overview

## General Execution with Dependencies

- Kafka Consumer Client should be set up to receive messages
  - Use com.datadito.kafka.message.UsageRecordMessage for the subscriber
- JSON processing may be necessary. Jackson could be utilized.
- Oracle JDBC driver should be used for connecting to Oracle DB
- Connection pooling via HikariCP
- Logging via SLF4J

## Docker
- Dockerfile should be made (not added as of now)

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
- MainTest.java (not coded as of now)
  - Tests Main CGF function

## Expected Output

Integration and testing with Oracle DB is currently lacking.

As of now, the program has been tested to produce the following output:

```

[main] INFO org.apache.kafka.clients.consumer.ConsumerConfig - ConsumerConfig values: 
	allow.auto.create.topics = true
	auto.commit.interval.ms = 5000
	auto.include.jmx.reporter = true
	auto.offset.reset = earliest
	bootstrap.servers = [localhost:9092]
	check.crcs = true
	client.dns.lookup = use_all_dns_ips
	client.id = consumer-UsageRecordConsumerGroup-1
	client.rack = 
	connections.max.idle.ms = 540000
	default.api.timeout.ms = 60000
	enable.auto.commit = true
	exclude.internal.topics = true
	fetch.max.bytes = 52428800
	fetch.max.wait.ms = 500
	fetch.min.bytes = 1
	group.id = UsageRecordConsumerGroup
	group.instance.id = null
	heartbeat.interval.ms = 3000
	interceptor.classes = []
	internal.leave.group.on.close = true
	internal.throw.on.fetch.stable.offset.unsupported = false
	isolation.level = read_uncommitted
	key.deserializer = class org.apache.kafka.common.serialization.StringDeserializer
	max.partition.fetch.bytes = 1048576
	max.poll.interval.ms = 300000
	max.poll.records = 500
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor, class org.apache.kafka.clients.consumer.CooperativeStickyAssignor]
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.connect.timeout.ms = null
	sasl.login.read.timeout.ms = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.login.retry.backoff.max.ms = 10000
	sasl.login.retry.backoff.ms = 100
	sasl.mechanism = GSSAPI
	sasl.oauthbearer.clock.skew.seconds = 30
	sasl.oauthbearer.expected.audience = null
	sasl.oauthbearer.expected.issuer = null
	sasl.oauthbearer.jwks.endpoint.refresh.ms = 3600000
	sasl.oauthbearer.jwks.endpoint.retry.backoff.max.ms = 10000
	sasl.oauthbearer.jwks.endpoint.retry.backoff.ms = 100
	sasl.oauthbearer.jwks.endpoint.url = null
	sasl.oauthbearer.scope.claim.name = scope
	sasl.oauthbearer.sub.claim.name = sub
	sasl.oauthbearer.token.endpoint.url = null
	security.protocol = PLAINTEXT
	security.providers = null
	send.buffer.bytes = 131072
	session.timeout.ms = 45000
	socket.connection.setup.timeout.max.ms = 30000
	socket.connection.setup.timeout.ms = 10000
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.3]
	ssl.endpoint.identification.algorithm = https
	ssl.engine.factory.class = null
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.certificate.chain = null
	ssl.keystore.key = null
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLSv1.3
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.certificates = null
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	value.deserializer = class com.i2i.datadito.kafka.deseralizer.UsageRecordMessageDes

[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version: 3.5.1
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId: 2c6fb6c54472e90a
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka startTimeMs: 1733677399774
[main] INFO org.apache.kafka.clients.consumer.KafkaConsumer - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] Subscribed to topic(s): UsageRecordTopic
Subscribed topics: [UsageRecordTopic]
[main] INFO org.apache.kafka.clients.Metadata - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] Cluster ID: MkU3OEVBNTcwNTJENDM2Qk
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] Discovered group coordinator localhost:9092 (id: 2147483646 rack: null)
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] (Re-)joining group
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] Request joining group due to: need to re-join with the given member-id: consumer-UsageRecordConsumerGroup-1-fd92da59-f889-473a-9a36-c1800a3edff5
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] Request joining group due to: rebalance failed due to 'The group member needs to have a valid member id before actually entering a consumer group.' (MemberIdRequiredException)
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] (Re-)joining group
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] Successfully joined group with generation Generation{generationId=4, memberId='consumer-UsageRecordConsumerGroup-1-fd92da59-f889-473a-9a36-c1800a3edff5', protocol='range'}
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] Finished assignment for group at generation 4: {consumer-UsageRecordConsumerGroup-1-fd92da59-f889-473a-9a36-c1800a3edff5=Assignment(partitions=[UsageRecordTopic-0])}
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] Successfully synced group in generation Generation{generationId=4, memberId='consumer-UsageRecordConsumerGroup-1-fd92da59-f889-473a-9a36-c1800a3edff5', protocol='range'}
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] Notifying assignor about the new Assignment(partitions=[UsageRecordTopic-0])
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] Adding newly assigned partitions: UsageRecordTopic-0
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-UsageRecordConsumerGroup-1, groupId=UsageRecordConsumerGroup] Setting offset for partition UsageRecordTopic-0 to the committed offset FetchPosition{offset=0, offsetEpoch=Optional.empty, currentLeader=LeaderAndEpoch{leader=Optional[localhost:9092 (id: 1 rack: null)], epoch=0}}
Polled record count: 0
Subscribed topics: [UsageRecordTopic]
Polled record count: 0
Subscribed topics: [UsageRecordTopic]
... // infinite loop continues execution

```
