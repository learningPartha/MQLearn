package com.springjmsasync.config;

import com.springjmsasync.receiver.MessageProductReceiver;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = "com.springjmsasync")
public class MessageConfiguration {

    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    private static final String MESSAGE_QUEUE = "spring_ASyncmessage_queue";


    @Bean
    public ConnectionFactory connectionFactory(){//configure connection factory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);//use custom url
        connectionFactory.setTrustedPackages(Arrays.asList("com.springjmsconsumer"));
        return connectionFactory;
    }

   /* @Bean
    public MessageListenerContainer getContainer(){// message listener container to invoke onmessage() on receiving message
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setDestinationName(MESSAGE_QUEUE);
        container.setMessageListener(messageProductReceiver);
        return container;
    }*/

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
