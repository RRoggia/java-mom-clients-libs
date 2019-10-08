## Core concepts

* Topic: resource to which messages are sent by publishers
* Subscription: A named resource representing stream of messages from a single, specific topic, to be delivered to the subscribing application
* Message: combination of data and header 
* Message attribute: key-value pair, that publishers can define for a message.

## publisher subscriber relationship

 Communication can be one-to-many (fan-out), many-to-one (fan-in), and many-to-many.

### Cloud Pub/Sub basic architecture

The system is designed to be *horizontally scalable*, where an increase in the number of topics, subscriptions, or messages can be handled by increasing the number of instances of running servers.

*data plane*: handles moving messages between publishers and subscribers

*control plane*: handles the assignment of publishers and subscribers to servers on the data plane.

The servers in the data plane are called *forwarders*, and the servers in the control plane are called *routers*.