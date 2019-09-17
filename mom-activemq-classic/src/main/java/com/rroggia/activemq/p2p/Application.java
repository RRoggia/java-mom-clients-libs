package com.rroggia.activemq.p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Application {
	private static final String TCP_CONNECTION_WITH_TIMEOUT = "tcp://localhost:61616?connectionTimeout=1000";

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(TCP_CONNECTION_WITH_TIMEOUT);

		try {
			Connection connection = connectionFactory.createConnection();

			Ping ping = new Ping(connection);
			new Pong(connection);

			connection.start();

			ping.producesToPong(connection);

		} catch (JMSException e) {
			System.out.println("Unable to create connection");
			System.out.println("Broker error message: " + e.getMessage());
		}

	}
}
