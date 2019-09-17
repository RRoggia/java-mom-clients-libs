package com.rroggia.activemq.pubsub.horses;

import javax.jms.Connection;
import javax.jms.MessageListener;

public class Thoroughbred extends Horse {

	public Thoroughbred(Connection connection) {
		super(connection);
	}

	@Override
	protected MessageListener getHorseBehavior() {
		return message -> System.out.println("Thoroughbred reached finish line.");
	}

}
