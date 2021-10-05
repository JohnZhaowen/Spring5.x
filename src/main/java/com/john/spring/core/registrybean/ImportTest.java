package com.john.spring.core.registrybean;

import com.john.spring.core.scope.ScopeConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ImportTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(name -> {
            String type = context.getType(name).toString();
            System.out.println(name + ": " + type);
        });

    }
}
