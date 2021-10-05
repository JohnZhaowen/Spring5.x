package com.john.spring.core.registrybean.factotybean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new MyBean();
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
