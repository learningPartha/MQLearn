package com.springjmsasync.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.springjmsasync")
@Import({MessageConfiguration.class,MessageListenerConfiguration.class})
public class AppConfig {

}
