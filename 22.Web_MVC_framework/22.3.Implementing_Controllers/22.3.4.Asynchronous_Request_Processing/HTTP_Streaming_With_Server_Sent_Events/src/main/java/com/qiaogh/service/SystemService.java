package com.qiaogh.service;

import com.qiaogh.domain.Time;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface SystemService {

    SseEmitter get( String id );
}
