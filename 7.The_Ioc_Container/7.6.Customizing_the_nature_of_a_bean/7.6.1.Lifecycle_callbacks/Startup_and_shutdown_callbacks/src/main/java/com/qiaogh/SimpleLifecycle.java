package com.qiaogh;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

@Component
public class SimpleLifecycle implements Lifecycle {

    public static String START_STATUS = "start";
    public static String STOP_STATUS = "stop";
    public static String START_FLAG;
    public static String STOP_FLAG;
    
    private boolean running = false;
    
    @Override
    public void start() {
        START_FLAG = START_STATUS;
        running = true;
    }

    @Override
    public void stop() {
        STOP_FLAG = STOP_STATUS;
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

}
