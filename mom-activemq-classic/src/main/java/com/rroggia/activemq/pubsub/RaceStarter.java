package com.rroggia.activemq.pubsub;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class RaceStarter {

	private Connection connection;

	private static final String PUB_SUB_START_RACE_TOPIC = "pubsub-start-race";

	public RaceStarter(Connection connection) {
		this.connection = connection;
	}

	public void startRace() {
		try {
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination topic = session.createTopic(PUB_SUB_START_RACE_TOPIC);

			MessageProducer producer = session.createProducer(topic);
			producer.send(session.createMessage());
			System.out.println("Boom. Race is started.");

		} catch (JMSException e) {
			System.out.println("Unable to start the race.");
			System.out.println("Broker error message is: " + e.getMessage());
		}
	}

}
