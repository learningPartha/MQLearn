package com.springactivemq;

import com.springactivemq.config.AppConfig;
import com.springactivemq.model.Product;
import com.springactivemq.sender.MessageProductSender;
import com.springactivemq.sender.MessageSender;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class MessageProducerApp {

    public static void main(String[] args){
        AbstractApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MessageSender messageSender = appContext.getBean(MessageSender.class);
        MessageProductSender messageProductSender =
                appContext.getBean(MessageProductSender.class);
        messageSender.sendMessage("Hello World!");
        System.out.println("Message has been sent successfully ");
        Product product = new Product();
        product.setProductId(100);
        product.setName("Laptop");
        product.setQuantity(10);
        messageProductSender.sendMessage(product);
        System.out.println("Message Product has been sent successfully ");
        ((AbstractApplicationContext)appContext).close();
    }

}
