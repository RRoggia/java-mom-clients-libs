package com.rroggia.jms.p2p;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import com.rabbitmq.jms.admin.RMQConnectionFactory;

@Profile("rabbitmq")
@Configuration
@EnableJms
public class RabbitMQConfig {

	@Bean
	public ConnectionFactory getConnectionFactory() {
		return new RMQConnectionFactory();
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(getConnectionFactory());
		return factory;
	}

}
