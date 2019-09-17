package com.rroggia.activemq.pubsub.horses;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;

public abstract class Horse {

	private static final String PUB_SUB_START_RACE_TOPIC = "pubsub-start-race";

	public Horse(Connection connection) {
		try {
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination startRaceTopic = session.createTopic(PUB_SUB_START_RACE_TOPIC);
			MessageConsumer consumer = session.createConsumer(startRaceTopic);
			consumer.setMessageListener(getHorseBehavior());
		} catch (JMSException e) {
			System.out.println("Unable to create connection");
			System.out.println("Error message " + e.getMessage());
			e.printStackTrace();
		}
	}

	protected abstract MessageListener getHorseBehavior();

}
