package com.john.spring.core.registrybean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前标注有@Import的类的注解信息
     * @param registry beanDefinition注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        if(registry.containsBeanDefinition("com.john.spring.core.registrybean.SelectorBean01")
                && registry.containsBeanDefinition("com.john.spring.core.registrybean.SelectorBean02")){

            registry.registerBeanDefinition("registrarBean01", new RootBeanDefinition(RegistrarBean01.class));
            registry.registerBeanDefinition("registrarBean02", new RootBeanDefinition(RegistrarBean02.class));
        }

    }
}
