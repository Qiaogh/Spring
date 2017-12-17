package com.qiaogh.service.impl;

import com.qiaogh.domain.Time;
import com.qiaogh.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Service( "systemService" )
@EnableScheduling
public class SystemServiceImpl implements SystemService {
    private static final Logger LOGGER = LoggerFactory.getLogger( SystemServiceImpl.class );

    private Map<String, Time> cached = new HashMap<>( 100 );

    @Override
    public Time get( String id ) {
        if ( !cached.containsKey( id ) ) {
            cached.put( id, new Time( "0" ) );
        }
        return cached.get( id );
    }

    @Scheduled( fixedDelay = 1000 )
    public void refresh() throws IOException {
        LOGGER.debug( "当前存在缓存数量：{}", new Object[] { cached.size() });
        Iterator<String> iterator = cached.keySet().iterator();
        Time time;
        while ( iterator.hasNext() ) {
            time = new Time( Long.valueOf( System.currentTimeMillis() ).toString() );
            cached.put( iterator.next(), time );
        }
    }
}
