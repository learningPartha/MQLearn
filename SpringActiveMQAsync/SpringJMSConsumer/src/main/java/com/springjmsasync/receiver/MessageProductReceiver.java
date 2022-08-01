package com.springjmsasync.receiver;

import com.springjmsasync.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class MessageProductReceiver implements MessageListener {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    MessageConverter messageConverter;

    public void onMessage(Message message){
        try{
            Product product = (Product) messageConverter.fromMessage(message);
            System.out.println("------- Inside onMessage-------");
            System.out.println(product);
            System.out.println("------- Inside onMessage-------");
        }
        catch(JMSException e){
            e.printStackTrace();
        }
    }

}
