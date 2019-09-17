package com.rroggia.activemq.pubsub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.rroggia.activemq.pubsub.horses.Appaloosa;
import com.rroggia.activemq.pubsub.horses.PaintHorse;
import com.rroggia.activemq.pubsub.horses.Thoroughbred;

public class RaceApplication {
	private static final String TCP_CONNECTION_WITH_TIMEOUT = "tcp://localhost:61616?connectionTimeout=1000";

	public static void main(String[] args) {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(TCP_CONNECTION_WITH_TIMEOUT);

		Connection connection;
		try {
			connection = connectionFactory.createConnection();

			new Appaloosa(connection);
			new PaintHorse(connection);
			new Thoroughbred(connection);

			new RaceStarter(connection).startRace();

			connection.start();

		} catch (JMSException e) {
			System.out.println("Unable to create connection");
			System.out.println("Broker error message: " + e.getMessage());
		}

	}
}
