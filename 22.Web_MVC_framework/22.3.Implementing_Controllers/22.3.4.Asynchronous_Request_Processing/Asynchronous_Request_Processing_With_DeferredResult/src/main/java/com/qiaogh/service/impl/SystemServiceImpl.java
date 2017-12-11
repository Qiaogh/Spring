package com.qiaogh.service.impl;

import com.qiaogh.domain.Time;
import com.qiaogh.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service( "systemService" )
@EnableScheduling
public class SystemServiceImpl implements SystemService {
    private static final Logger LOGGER = LoggerFactory.getLogger( SystemServiceImpl.class );

    private Map<String, DeferredResult<Time>> cached = new HashMap<>( 100 );

    @Override
    public DeferredResult<Time> get( String id ) {
        DeferredResult<Time> result = new DeferredResult<>();
        cached.put( id, result );
        return result;
    }

    @Scheduled( fixedDelay = 1000 )
    public void refresh() {
        LOGGER.debug( "当前存在缓存数量：{}", new Object[] { cached.size() });
        Set<Map.Entry<String, DeferredResult<Time>>> entrys = cached.entrySet();
        for ( Map.Entry<String, DeferredResult<Time>> entry : entrys ) {
            entry.getValue().setResult( new Time( Long.valueOf( System.currentTimeMillis() ).toString() ) );
        }
    }
}
