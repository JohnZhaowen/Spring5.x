package com.john.spring.core.test;

import com.john.spring.core.xml.MyUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.john.spring.core.test")
public class MyTestConfig {

    @Bean
    public MyUser myUser() {
        return new MyUser("zhangsan", 23);
    }
}
