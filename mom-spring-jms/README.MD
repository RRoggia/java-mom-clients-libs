# Spring JMS Client

Pros:
* Built on top of JMS (TODO verify version).
* Spring JMS has a more simplified API based on the spring programming model. JMS implementation is transparent to application code.
* Just as using the JMS API, you can easily inject a JMS implementation to change protocols and brokers with a small impact in the application code.
* [Open Source](https://github.com/spring-projects/spring-framework/tree/master/spring-jms).

Cons:
* Directly coupled to Spring programming model.


# Scenario
![spring jms using apache active mq client or apache qpid client](./spring-jms-client.png)
