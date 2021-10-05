package com.john.spring.core.registrybean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    /**
     * @param importingClassMetadata 当前处理的标注有@Import注解的类的注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{SelectorBean01.class.getName(), SelectorBean02.class.getName()};
    }

}
