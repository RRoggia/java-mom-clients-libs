package com.rroggia.activemq.p2p;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class Ping {

	private static final String P2P_PONG_QUEUE = "p2p-pong";
	private static final String P2P_PING_QUEUE = "p2p-ping";

	public Ping(Connection connection) {
		try {
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination pingQueue = session.createQueue(P2P_PING_QUEUE);
			MessageConsumer consumer = session.createConsumer(pingQueue);
			consumer.setMessageListener(consumesPing(connection));
		} catch (JMSException e) {
			System.out.println("Unable to create connection");
			System.out.println("Error message " + e.getMessage());
			e.printStackTrace();
		}
	}

	private MessageListener consumesPing(Connection connection) {
		return message -> {
			System.out.println("ping");
			producesToPong(connection);
		};
	}

	public void producesToPong(Connection connection) {
		try {
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination pongQueue = session.createQueue(P2P_PONG_QUEUE);
			MessageProducer producer = session.createProducer(pongQueue);
			producer.send(session.createMessage());
			session.close();
		} catch (JMSException e) {
			System.out.println("Error producing to pong.");
			System.out.println("Error message " + e.getMessage());
		}
	}

}
