package com.rroggia.activemq.pubsub.horses;

import javax.jms.Connection;
import javax.jms.MessageListener;

public class PaintHorse extends Horse {

	public PaintHorse(Connection connection) {
		super(connection);
	}

	@Override
	protected MessageListener getHorseBehavior() {
		return message -> System.out.println("Paint Horse reached finish line.");
	}

}
