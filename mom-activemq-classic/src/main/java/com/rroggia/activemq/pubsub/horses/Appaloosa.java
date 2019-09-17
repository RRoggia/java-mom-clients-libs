package com.rroggia.activemq.pubsub.horses;

import javax.jms.Connection;
import javax.jms.MessageListener;

public class Appaloosa extends Horse {

	public Appaloosa(Connection connection) {
		super(connection);
	}

	@Override
	protected MessageListener getHorseBehavior() {
		return message -> System.out.println("Appaloosa reached finish line.");
	}

}
