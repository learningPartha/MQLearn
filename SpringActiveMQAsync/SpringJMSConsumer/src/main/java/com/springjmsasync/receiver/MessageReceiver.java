package com.springjmsasync.receiver;

import javax.jms.JMSException;

import com.springjmsasync.model.Product;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    private static final String MESSAGE_QUEUE = "spring_ASyncmessage_queue";

    @JmsListener(destination = MESSAGE_QUEUE)
    public void receiveMessage(final Message<Product> message)
            throws JMSException
    {
        MessageHeaders headers = message.getHeaders();
        System.out.println("headers = " + headers);

        Product product = message.getPayload();
        System.out.println("product = " + product);

    }

}
