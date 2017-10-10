package com.qiaogh.resovler;

import org.springframework.test.context.ActiveProfilesResolver;

public class SimpleActiveProfilesResolver implements ActiveProfilesResolver {

    private static final String[] VILLAGE_PROFILE = new String[] { "village" };
    
    @Override
    public String[] resolve( Class<?> testClass ) {
        return VILLAGE_PROFILE;
    }
}
