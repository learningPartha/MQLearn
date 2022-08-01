package com.springactivemq.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.springactivemq")
@Import({MessageConfiguration.class})
public class AppConfig {

}
