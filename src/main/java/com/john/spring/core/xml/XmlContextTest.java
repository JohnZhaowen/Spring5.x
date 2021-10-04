package com.john.spring.core.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        System.out.println(context.getBean(MyUser.class));

    }
}
