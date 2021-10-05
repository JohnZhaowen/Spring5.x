package com.john.spring.core.lifecycle;

import com.john.spring.core.registrybean.ImportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Objects;

public class LifeCycleTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(name -> {
            if(name.equals("cat")){
                String type = Objects.requireNonNull(context.getType(name)).toString();
                System.out.println(name + ": " + type);
            }
        });
        //会调用bean生命周期函数的销毁方法
        context.close();
    }
}
