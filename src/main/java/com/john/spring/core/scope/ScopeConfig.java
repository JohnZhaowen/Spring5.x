package com.john.spring.core.scope;

import com.john.spring.core.registrybean.Color;
import com.john.spring.core.registrybean.MyImportBeanDefinitionRegistrar;
import com.john.spring.core.registrybean.MyImportSelector;
import com.john.spring.core.xml.MyUser;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * 对该类的所有bean起作用
 */
//@Conditional({LinuxCondition.class})
@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class ScopeConfig {
    /**
     * 共有以下四种选项：
     * 	 ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * 	 ConfigurableBeanFactory#SCOPE_SINGLETON
     * 	 org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * 	 org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * 	1. 在单例模式下，context启动后，bean就准备好了(@Lazy(false))
     * 	   该方法只会执行一次
     * 	   每次获取到的bean是相同的
     * 	2. 在prototype模式下，只有获取时才进行bean的创建
     * 	   该方法每次获取bean时都会执行
     * 	   每次获取的bean不同
     *
     * @Lazy
     *
     */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public MyUser myUser(){
        System.out.println("create myUser...");
        return new MyUser("scope", 10);
    }

    /**
     * 按条件加载bean
     */
    @Bean
    @Conditional({WindowsCondition.class})
    public MyUser windowsUser(){
        return new MyUser("bill gates", 63);
    }

    @Bean
    public MyUser linuxUser(){
        return new MyUser("linus", 48);
    }
}
