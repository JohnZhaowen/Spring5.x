package com.john.spring.core.xml;

import com.john.spring.john.JohnConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XmlContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("john-config.xml");
        String[] names = context.getBeanNamesForType(JohnConfig.class);
        Arrays.stream(names).forEach(System.out::println);

    }
}
