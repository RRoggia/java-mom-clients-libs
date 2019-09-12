package com.rroggia.activemq.p2p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

public class Ping {

	@Autowired
	private JmsTemplate jmsTemplate;

	@JmsListener(destination = "p2p-ping")
	public void listenPingQueue(String textMessage) {
		System.out.println("ping");
		jmsTemplate.send("p2p-pong", session -> session.createMessage());
	}

}
