package com.john.spring.core.registrybean;

import com.john.spring.core.registrybean.factotybean.MyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 对该类的所有bean起作用
 */
@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class ImportConfig {

    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }
}
