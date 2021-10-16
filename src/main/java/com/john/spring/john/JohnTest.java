package com.john.spring.john;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class JohnTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JohnConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        String[] johnName = context.getBeanNamesForType(John.class);

        System.out.println(context.getBean(JohnConfig.class).getBean() == context.getBean(John.class));

        System.out.println("=================");
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        System.out.println("=================");
        Arrays.stream(johnName).forEach(System.out::println);
    }
}
