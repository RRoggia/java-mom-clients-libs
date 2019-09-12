# Comparsion of Message Oriented Middleware's Java Client libraries
Comparsion of Message Oriented Middleware's Java Client libraries

## Active MQ Classic (Amazon MQ)
* [Active MQ Client through TCP](https://github.wdf.sap.corp/I840973/java-mom-client/tree/master/mom-activemq-classic)
* [Apache Qpid JMS Client through AMQP 1.0](https://github.wdf.sap.corp/I840973/java-mom-client/tree/master/mom-activemq-qpid)
* [Spring JMS with amqp and tcp](https://github.wdf.sap.corp/I840973/java-mom-client/tree/master/mom-activemq-spring-jms)

## Notes

### JMS
* Java applications should rely on JMS. Using the JMS specification decouples our application code and the message-oriented middleware. Same as JPA does for database.
* There are two versions of JMS (1.1 and 2.0). 1.1 is synchronous and verbose, while 2.0 is assynchronous and simplified. It's retrocompatible though.
* JMS is not supported by all the MoMs. Some don't support at all (e.g. GCP Pub/Sub), some only support version 1.1.
* JMS does *not* enforces a communication protocol.
* For Spring Applications, spring provides a wrapper on top of the JMS API.
