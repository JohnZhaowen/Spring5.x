package com.john.spring.core.value;

import com.john.spring.core.xml.MyUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ValueTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ValueConfig.class);
        System.out.println(context.getBean(ValueUser.class));
    }
}
