package com.rroggia.activemq.p2p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

public class Pong {

	@Autowired
	private JmsTemplate jmsTemplate;

	@JmsListener(destination = "p2p-pong")
	public void listenPingQueue(String textMessage) {
		System.out.println("pong");
		jmsTemplate.send("p2p-ping", session -> session.createMessage());
	}

}
