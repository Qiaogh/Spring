package com.qiaogh.convert;

import java.awt.Color;

import org.springframework.core.convert.converter.Converter;

import sun.beans.editors.ColorEditor;

public class StringToColorConverter implements Converter<String, Color> {

    private ColorEditor colorEditor = new ColorEditor();
    
    @Override
    public Color convert( String source ) {
        colorEditor.setAsText( source );
        return (Color) colorEditor.getValue();
    }

}
