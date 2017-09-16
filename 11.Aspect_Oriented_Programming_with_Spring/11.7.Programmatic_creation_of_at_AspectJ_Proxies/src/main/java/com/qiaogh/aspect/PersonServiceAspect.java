package com.qiaogh.aspect;

import java.util.HashMap;
import java.util.Map;

public interface PersonServiceAspect {

    String BEFORE_GET = "before_get";
    
    Map<String, String> INVOKED_ADVICES = new HashMap<String, String>();
    
    public void beforeGet();
}
