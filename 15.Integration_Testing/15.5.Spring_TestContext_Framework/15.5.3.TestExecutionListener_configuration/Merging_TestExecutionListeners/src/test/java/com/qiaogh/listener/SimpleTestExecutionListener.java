package com.qiaogh.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class SimpleTestExecutionListener implements TestExecutionListener {
    
    public static final String BEFORE_TEST_CLASS = "beforeTestClass";
    public static final String BEFORE_TEST_METHOD = "beforeTestMethod";
    public static final String AFTER_TEST_METHOD = "afterTestMethod";
    
    public static final List<String> INVOKED = new ArrayList<String>(); 

    @Override
    public void beforeTestClass( TestContext testContext ) throws Exception {
        INVOKED.add( BEFORE_TEST_CLASS );
    }

    @Override
    public void prepareTestInstance( TestContext testContext ) throws Exception {
    }

    @Override
    public void beforeTestMethod( TestContext testContext ) throws Exception {
        INVOKED.add( BEFORE_TEST_METHOD );
    }

    @Override
    public void afterTestMethod( TestContext testContext ) throws Exception {
        INVOKED.add( AFTER_TEST_METHOD );
    }

    @Override
    public void afterTestClass( TestContext testContext ) throws Exception {
    }
}
