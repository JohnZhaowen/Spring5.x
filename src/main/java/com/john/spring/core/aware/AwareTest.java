package com.john.spring.core.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);

    }
}
