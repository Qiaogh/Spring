package com.qiaogh.config.filter;

import java.io.IOException;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import com.qiaogh.domain.Man;
import com.qiaogh.domain.Women;

public class KidFilter implements TypeFilter {

    @Override
    public boolean match( MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory ) throws IOException {
        ClassMetadata metadata = metadataReader.getClassMetadata();
        String className = metadata.getClassName();
        return !Man.class.getName().equals( className ) && !Women.class.getName().equals( className );
    }

}
