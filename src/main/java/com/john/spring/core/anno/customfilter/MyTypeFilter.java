package com.john.spring.core.anno.customfilter;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader 当前扫描到的类的元素据读取类，主要读取注解信息，类信息和resource信息（包路径等）
     * @param metadataReaderFactory 可用于读取其他类相关信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        if (annotationMetadata.hasAnnotation(MyService.class.getName())) {
            return true;
        }

        return false;
    }
}
