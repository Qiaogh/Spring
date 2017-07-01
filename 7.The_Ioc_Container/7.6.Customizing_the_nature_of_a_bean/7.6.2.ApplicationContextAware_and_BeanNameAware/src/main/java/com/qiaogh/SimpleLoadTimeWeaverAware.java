package com.qiaogh;

import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.stereotype.Component;

@Component
public class SimpleLoadTimeWeaverAware implements LoadTimeWeaverAware {

    private LoadTimeWeaver loadTimeWeaver;
    
    @Override
    public void setLoadTimeWeaver( LoadTimeWeaver loadTimeWeaver ) {
        this.loadTimeWeaver = loadTimeWeaver;
    }

    public LoadTimeWeaver getLoadTimeWeaver() {
        return loadTimeWeaver;
    }
}
