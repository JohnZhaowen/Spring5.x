package com.john.spring.core.scope;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断当前系统是否是Windows系统
 */
public class WindowsCondition implements Condition {

    /**
     * 返回true则加载对应的bean，反之亦然
     * @param context 上下文信息，如beanFactory, env...
     * @param metadata 当前处理类或方法的元信息，如注解信息，方法信息等
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("os.name").contains("Windows");
    }
}
