package com.john.spring.john;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "myFirstConfig")
public class JohnConfig {

    @Autowired
    private ApplicationContext context;

    @Bean
    public John john(){
        return new John("zhangsan", 10);
    }

    public Object getBean(){
        return context.getBean("john");
    }
}
