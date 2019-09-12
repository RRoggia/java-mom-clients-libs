# ActiveMQ Classic Client

Pro:
* Support to JMS 1.1.
* Supports connections using `tcp`, `ssl`, `nio`, `nio+ssl`.
* Default client option for ActiveMQ Classic, and therefore, for the aws service [amazon mq](https://aws.amazon.com/pt/amazon-mq/).
* [Open Source](https://github.com/apache/activemq/tree/master/activemq-client).

Cons:
* It don't have support to JMS 2.0
* Requires extensions (Qpid Proton) to support other protocols such `amqp`.

# Scenario
![activemq client using tcp and activemq](https://github.wdf.sap.corp/raw/I840973/java-mom-client/master/mom-activemq-classic/activemq-client.jpg)

# Implementation
## ActiveMQConnectionFactory
`ActiveMQConnectionFactory` implements the JMS interfaces `ConnectionFactory`, `QueueConnectionFactory` and `TopicConnectionFactory`. Which enables it to create any type of connections.

### Creating a Connection
* `ConnectionFactory.createConnection` -> supports any channel
* `QueueConnectionFactory.createQueueConnection` -> only supports point to point channel
* `TopicConnectionFactory.createTopicConnection` -> only sypports publisher subscriber channel

#### Default Connection Settings
When creating a new instance of the `ActiveMQConnectionFactory` the implementation looks for the System properties `org.apache.activemq.AMQ_HOST` and `org.apache.activemq.AMQ_PORT`. If they are empty the implementation tries to find the System properties `AMQ_HOST` and `AMQ_PORT` otherwise the default is `localhost` and `61616`.

#### Channing Connection
You can also use any of the `AcgiveMQConnectionFactory` constructor to override the default connection settings.

## ActiveMQConnection
`ActiveMQConnection` implements the JMS interfaces `Connection`, `QueueConnection` and `TopicConnection`.

A `Connection` may:
* `.start()` and `.stop()` the `Connection`.
* Create a `Session`.

## ActiveMQSession
`ActiveMQSession` implements the JMS interfaces `Session` , `QueueSession`, `TopicSession`.

A `Session` may:
* Create a `MessageConsumer` based on a `Destination`.
* Create a `MessageProducer` based on a `Destination`.
* Create a `Message`.
* Create a `Destination` .

## ActiveMQMessageConsumer
`ActiveMQMessageConsumer` implements the `MessageAvailableConsumer` which extends the JMS interface `MessageConsumer`.

A `MessageConsumer` `receive`s `Message`s from a `Destination`.

## ActiveMQMessageProducer
`ActiveMQMessageProducer` extends `ActiveMQMessageProducerSupport` which implements the JMS interface `MessageProducer`.

A `MessageProducer` `send`s `Message`s to a `Destination`.

## ActiveMQDestination
`ActiveMQDestination` implements the JMS interface `Destination`.

`ActiveMQDestination` has two subclasses:
* `ActiveMQQueue` which implements the JMS interface `Queue`.
* `ActiveMQTopic` which implements the JMS interface `Topic`.
