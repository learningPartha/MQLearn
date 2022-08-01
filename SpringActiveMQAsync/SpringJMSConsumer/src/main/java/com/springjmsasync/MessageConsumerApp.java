package com.springjmsasync;

import com.springjmsasync.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageConsumerApp {

    public static void main(String[] args){

        AbstractApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        try{
            Thread.sleep(6000000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        ((AbstractApplicationContext)appContext).close();
    }
}
