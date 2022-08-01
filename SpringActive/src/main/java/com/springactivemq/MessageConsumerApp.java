package com.springactivemq;

import com.springactivemq.config.AppConfig;
import com.springactivemq.model.Product;
import com.springactivemq.receiver.MessageProductReceiver;
import com.springactivemq.receiver.MessageReceiver;
import com.springactivemq.sender.MessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageConsumerApp {

    public static void main(String[] args) {
        AbstractApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MessageReceiver messageReceiver = appContext.getBean(MessageReceiver.class);
        MessageProductReceiver messageProductReceiver =
                (MessageProductReceiver) appContext.getBean(MessageProductReceiver.class);
        String response = messageReceiver.receiveMessage();
        Product product = messageProductReceiver.receiveMessage();
        System.out.println("Message Received = " + response);
        System.out.println("Message Product Received = " + product);
        ((AbstractApplicationContext) appContext).close();
    }

}
