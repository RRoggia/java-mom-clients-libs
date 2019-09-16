package com.rroggia.rabbitmq.p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import com.rabbitmq.jms.admin.RMQConnectionFactory;

public class Application {
	public static void main(String[] args) {

		ConnectionFactory connectionFactory = new RMQConnectionFactory();

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
