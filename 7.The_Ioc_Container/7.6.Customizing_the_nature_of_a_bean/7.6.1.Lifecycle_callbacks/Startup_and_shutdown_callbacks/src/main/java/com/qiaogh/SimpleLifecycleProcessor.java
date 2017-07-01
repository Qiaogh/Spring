package com.qiaogh;

import org.springframework.context.support.DefaultLifecycleProcessor;
import org.springframework.stereotype.Component;

@Component( "lifecycleProcessor" )
public class SimpleLifecycleProcessor extends DefaultLifecycleProcessor {

    @Override
    public void onRefresh() {
        start();
    }
    
    @Override
    public void onClose() {
        stop();
    }
}
