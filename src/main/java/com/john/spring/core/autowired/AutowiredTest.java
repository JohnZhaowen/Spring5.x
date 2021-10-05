package com.john.spring.core.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        context.getBean(BookController.class).getService();
    }
}
