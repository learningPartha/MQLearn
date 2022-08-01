package com.springactivemq.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import com.springactivemq.receiver.MessageProductReceiver;
import com.springactivemq.receiver.MessageReceiver;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
@ComponentScan(basePackages = "com.springactivemq")
public class MessageConfiguration {

    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    private static final String MESSAGE_QUEUE = "spring_message_queue";

    @Autowired
    MessageReceiver messageReceiver;

    @Autowired
    MessageProductReceiver messageProductReceiver;

    @Bean
    public ConnectionFactory connectionFactory(){//configure connection factory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);//use custom url
        connectionFactory.setTrustedPackages(Arrays.asList("com.springactivemq"));
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){//configure JMS template
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestinationName(MESSAGE_QUEUE);
        return jmsTemplate;
    }

    @Bean
    MessageConverter messageConverter(){//convert message
        return new SimpleMessageConverter();
    }

}
