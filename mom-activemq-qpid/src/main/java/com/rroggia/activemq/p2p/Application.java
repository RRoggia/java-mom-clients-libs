package com.rroggia.activemq.p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.qpid.jms.JmsConnectionFactory;

public class Application {
	public static void main(String[] args) {

		ConnectionFactory connectionFactory = new JmsConnectionFactory();

		try {
			Connection connection = connectionFactory.createConnection();

			Ping ping = new Ping(connection);
			new Pong(connection);

			connection.start();

			ping.producesToPong(connection);

		} catch (JMSException e) {
			System.out.println("Unable to create connection");
			System.out.println("Error message " + e.getMessage());
			e.printStackTrace();
		}

	}

}
