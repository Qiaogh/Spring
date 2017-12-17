package com.qiaogh.service.impl;

import com.qiaogh.domain.Time;
import com.qiaogh.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service( "systemService" )
@EnableScheduling
public class SystemServiceImpl implements SystemService {
    private static final Logger LOGGER = LoggerFactory.getLogger( SystemServiceImpl.class );

    private Map<String, SseEmitter> cached = new HashMap<>( 100 );

    @Override
    public SseEmitter get( String id ) {
        if ( !cached.containsKey( id ) ) {
            SseEmitter result = new SseEmitter( 10000000L );
            cached.put( id, result );
        }
        return cached.get( id );
    }

    @Scheduled( fixedDelay = 1000 )
    public void refresh() throws IOException {
        LOGGER.debug( "当前存在缓存数量：{}", new Object[] { cached.size() });
        Set<Map.Entry<String, SseEmitter>> entrys = cached.entrySet();
        for ( Map.Entry<String, SseEmitter> entry : entrys ) {
            entry.getValue().send( new Time( Long.valueOf( System.currentTimeMillis() ).toString() ) );
        }
    }
}
