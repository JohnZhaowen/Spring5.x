package com.john.spring.core.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class LifeCycleConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

    @Bean
    public Cat cat() {
        return new Cat();
    }

}
