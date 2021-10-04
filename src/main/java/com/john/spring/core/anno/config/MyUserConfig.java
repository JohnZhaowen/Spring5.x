package com.john.spring.core.anno.config;

import com.john.spring.core.anno.controller.MyUserController;
import com.john.spring.core.anno.customfilter.MyTypeFilter;
import com.john.spring.core.xml.MyUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        value = "com.john.spring.core.anno",
        excludeFilters = {
//                @Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        },
        includeFilters = {
                @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MyUserController.class}),
                @Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        }


)
public class MyUserConfig {

    @Bean
    public MyUser myUser(){
//        MyUser myUser = new MyUser();
//        myUser.setName("lisi");
//        myUser.setAge(19);
//        return myUser;

        return new MyUser("wangwu", 20);
    }
}
