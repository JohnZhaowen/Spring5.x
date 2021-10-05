package com.john.spring.core.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class MyAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean组件的id： " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("current context : " + applicationContext);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("hello ${os.name}, i now #{20+30}");
        System.out.println("resolved value: " + s);
    }
}
