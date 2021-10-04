package com.john.spring.core.anno;

import com.john.spring.core.anno.config.MyUserConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AnnoTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyUserConfig.class);
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(name -> System.out.println(name));
    }
}
