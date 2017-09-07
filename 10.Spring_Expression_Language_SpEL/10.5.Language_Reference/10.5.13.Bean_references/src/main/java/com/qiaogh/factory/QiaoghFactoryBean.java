package com.qiaogh.factory;

import org.springframework.beans.factory.FactoryBean;

import com.qiaogh.domain.Qiaogh;

public class QiaoghFactoryBean implements FactoryBean<Qiaogh> {

    @Override
    public Qiaogh getObject() throws Exception {
        return Qiaogh.getInstance();
    }

    @Override
    public Class<?> getObjectType() {
        return Qiaogh.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
