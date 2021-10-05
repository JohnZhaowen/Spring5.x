package com.john.spring.core.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {

    public Dog(){
        System.out.println("dog...construct...");
    }

    @PostConstruct
    public void init(){
        System.out.println("dog...init...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("dog...destroy...");
    }
}
