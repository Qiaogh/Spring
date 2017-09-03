package com.qiaogh.org.springframework.util;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.ClassUtils;

public class ClassUtilsTest {

    @Test
    public void testIsPresent() {
        String clazz = ClassUtilsTest.class.getName();
        ClassLoader classLoader = ClassUtilsTest.class.getClassLoader();
        Assert.assertTrue( ClassUtils.isPresent( clazz, classLoader ) );
    }
}
