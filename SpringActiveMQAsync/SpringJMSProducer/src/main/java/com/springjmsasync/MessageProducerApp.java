package com.springjmsasync;

import com.springjmsasync.config.AppConfig;
import com.springjmsasync.model.Product;
import com.springjmsasync.producer.MessageProductSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageProducerApp {

    public static void main(String[] args){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);

        MessageProductSender messageSender = context.getBean(MessageProductSender.class);

        Product product = new Product();
        product.setProductId(100);
        product.setName("Laptop");
        product.setQuantity(10);

        messageSender.sendMessage(product);
        System.out.println("Message has been sent successfully to Queue");

        ((AbstractApplicationContext) context).close();
    }
}
