package com.qiaogh;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageSourceAware implements MessageSourceAware {

    private MessageSource messageSource;
    
    @Override
    public void setMessageSource( MessageSource messageSource ) {
        this.messageSource = messageSource;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }
}
