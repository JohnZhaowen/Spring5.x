package com.john.spring.core.value;

import com.john.spring.core.xml.MyUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//引入配置文件，保存到运行时的环境变量中
@PropertySource(value = {"classpath:application.properties"})
public class ValueConfig {

    @Bean
    public ValueUser valueUser(){
        return new ValueUser();
    }

}
