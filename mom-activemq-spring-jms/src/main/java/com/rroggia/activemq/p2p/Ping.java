package com.rroggia.activemq.p2p;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Ping {

	@Autowired
	private JmsTemplate jmsTemplate;

	@PostConstruct
	public void init() {
		listenPingQueue();
	}

	@JmsListener(destination = "p2p-ping")
	public void listenPingQueue() {
		System.out.println("ping");
		jmsTemplate.send("p2p-pong", session -> session.createMessage());
	}

}
