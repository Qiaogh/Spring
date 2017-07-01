package com.qiaogh.java.beans;

import org.junit.Assert;
import org.junit.Test;

import java.beans.Introspector;

/**
 * Created by qiaogh on 2017/3/11.
 */
public class IntrospectorTest {

    @Test
    public void testDecapitalize() {
        String decapitalizedName = Introspector.decapitalize( "UserService" );
        Assert.assertTrue( "userService".equals( decapitalizedName ) );
    }
}
