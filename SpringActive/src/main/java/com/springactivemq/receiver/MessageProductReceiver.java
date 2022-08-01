package com.springactivemq.receiver;

import com.springactivemq.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class MessageProductReceiver {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    MessageConverter messageConverter;

    public Product receiveMessage(){
        try{
            Message message = jmsTemplate.receive();
            Product product = (Product) messageConverter.fromMessage(message);
            return product;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
