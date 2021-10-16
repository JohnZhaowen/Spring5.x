package com.john.spring.core.test;

import com.john.spring.core.xml.MyUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyTestConfig.class);
        System.out.println(context.getBean(MyTestController.class));
        System.out.println(context.getBean(MyTestConfig.class));
        System.out.println(context.getBean(MyUser.class));
    }
}
