package com.qiaogh.service;

import com.qiaogh.domain.Time;
import org.springframework.web.context.request.async.DeferredResult;

public interface SystemService {

    DeferredResult<Time> get( String id );
}
