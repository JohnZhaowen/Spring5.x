package com.john.spring.core.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class MyAllAware implements
        ApplicationContextAware,
        NotificationPublisherAware,
        ApplicationEventPublisherAware,
        BeanNameAware,
        EnvironmentAware,
        BeanFactoryAware,
        ImportAware,
        BeanClassLoaderAware,
        ResourceLoaderAware,
        EmbeddedValueResolverAware,
        MessageSourceAware,
        LoadTimeWeaverAware,
        Aware {

    //================================================AbstractAutowireCapableBeanFactory=========================================================================
    @Override
    public void setBeanName(String name) {//1 AbstractAutowireCapableBeanFactory void invokeAwareMethods(String beanName, Object bean)
        System.out.println("Aware name: " + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {//2 AbstractAutowireCapableBeanFactory void invokeAwareMethods(String beanName, Object bean)
        System.out.println("Aware classLoader: " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {//3 AbstractAutowireCapableBeanFactory void invokeAwareMethods(String beanName, Object bean)
        System.out.println("Aware beanFactory: " + beanFactory);
    }

    //================================================ApplicationContextAwareProcessor=========================================================================
    @Override
    public void setEnvironment(Environment environment) {//4 ApplicationContextAwareProcessor void invokeAwareInterfaces(Object bean)
        System.out.println("Aware environment: " + environment);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {//5. ApplicationContextAwareProcessor void invokeAwareInterfaces(Object bean)
        System.out.println("Aware resolver: " + resolver);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {//6 ApplicationContextAwareProcessor void invokeAwareInterfaces(Object bean)
        System.out.println("Aware resourceLoader: " + resourceLoader);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {//7 ApplicationContextAwareProcessor void invokeAwareInterfaces(Object bean)
        System.out.println("Aware applicationEventPublisher: " + applicationEventPublisher);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {//8 ApplicationContextAwareProcessor void invokeAwareInterfaces(Object bean)
        System.out.println("Aware messageSource: " + messageSource);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {//9 ApplicationContextAwareProcessor void invokeAwareInterfaces(Object bean)
        System.out.println("Aware applicationContext: " + applicationContext);
    }

    //================================================no caller==================================================================================================
    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {// no
        System.out.println("Aware importMetadata: " + importMetadata);
    }

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {//no
        System.out.println("Aware loadTimeWeaver: " + loadTimeWeaver);
    }

    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {//no
        System.out.println("Aware notificationPublisher: " + notificationPublisher);
    }
}
