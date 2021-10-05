package com.john.spring.core.scope;

import com.john.spring.core.xml.MyUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ScopeTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


    }


}
