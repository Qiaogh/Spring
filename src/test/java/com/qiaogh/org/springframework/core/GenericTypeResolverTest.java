package com.qiaogh.org.springframework.core;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.GenericTypeResolver;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;

public class GenericTypeResolverTest {

    @Test
    public void testResolveTypeArgument() {
        Class<?> annotationType = GenericTypeResolver.resolveTypeArgument( NumberFormatAnnotationFormatterFactory.class, AnnotationFormatterFactory.class );
        Assert.assertEquals( NumberFormat.class, annotationType );
        Assert.assertNull( GenericTypeResolver.resolveTypeArgument( ArrayList.class, List.class ) );
        Class<?> userType = GenericTypeResolver.resolveTypeArgument( UserList.class, List.class );
        Assert.assertEquals( User.class, userType );
    }
    
    private class User {}
    
    @SuppressWarnings( "serial" )
    private class UserList extends ArrayList<User> {}
}
