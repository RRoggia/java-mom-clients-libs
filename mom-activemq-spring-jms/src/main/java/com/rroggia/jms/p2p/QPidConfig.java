package com.rroggia.jms.p2p;

import javax.jms.ConnectionFactory;

import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Profile("qpid")
@Configuration
@EnableJms
public class QPidConfig {

	@Bean
	public ConnectionFactory getConnectionFactory() {
		return new JmsConnectionFactory();
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(getConnectionFactory());
		return factory;
	}

}
