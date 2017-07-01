package com.qiaogh;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class SimpleSmartLifecycle implements SmartLifecycle {
    
    public static String START_STATUS = "start";
    public static String STOP_STATUS = "stop";
    public static String CALLBACK_STOP_STATUS = "callback_stop";
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

    @Override
    public int getPhase() {
        return Integer.MIN_VALUE;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop( Runnable callback ) {
        new Thread( callback ).start();
        STOP_FLAG = CALLBACK_STOP_STATUS;
        running = false;
    }

}
