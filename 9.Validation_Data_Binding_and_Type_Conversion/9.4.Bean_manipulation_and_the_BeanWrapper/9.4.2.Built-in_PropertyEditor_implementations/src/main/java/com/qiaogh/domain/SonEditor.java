package com.qiaogh.domain;

import java.beans.PropertyEditorSupport;

public class SonEditor extends PropertyEditorSupport {

    @Override
    public void setAsText( String text ) throws IllegalArgumentException {
        setValue( new Son( text ) );
    }
    
    @Override
    public String getAsText() {
        return getValue().toString();
    }
}
