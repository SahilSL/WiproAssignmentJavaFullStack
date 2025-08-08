package com.wipro.springassignment1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.wipro.springassignment1")
@PropertySource("classpath:datafiles.properties")
public class AppConfig {
}

