package com.rroggia.activemq.p2p;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class Pong {

	private static final String P2P_PONG_QUEUE = "p2p-pong";
	private static final String P2P_PING_QUEUE = "p2p-ping";

	public Pong(Connection connection) {

		try {
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination pongQueue = session.createQueue(P2P_PONG_QUEUE);
			MessageConsumer consumer = session.createConsumer(pongQueue);
			consumer.setMessageListener(consumesPong(connection));
		} catch (JMSException e) {
			System.out.println("Unable to create connection");
			System.out.println("Error message " + e.getMessage());
			e.printStackTrace();
		}
	}

	private MessageListener consumesPong(Connection connection) {
		return message -> {
			System.out.println("pong");
			producesToPing(connection);
		};
	}

	public void producesToPing(Connection connection) {
		try {
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination pingQueue = session.createQueue(P2P_PING_QUEUE);
			MessageProducer producer = session.createProducer(pingQueue);
			producer.send(session.createMessage());
			session.close();
		} catch (JMSException e) {
			System.out.println("Error producing to pong.");
			System.out.println("Error message " + e.getMessage());
		}
	}

}
