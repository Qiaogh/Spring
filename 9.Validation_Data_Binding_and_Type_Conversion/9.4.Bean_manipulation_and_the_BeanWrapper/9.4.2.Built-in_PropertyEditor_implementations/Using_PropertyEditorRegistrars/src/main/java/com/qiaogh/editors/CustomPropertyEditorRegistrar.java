package com.qiaogh.editors;

import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyEditorSupport;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import sun.beans.editors.ColorEditor;
import sun.beans.editors.EnumEditor;
import sun.beans.editors.FontEditor;
import sun.beans.editors.ShortEditor;

import com.qiaogh.domain.Son;
import com.qiaogh.util.DateUtil;
import com.qiaogh.util.Sex;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors( PropertyEditorRegistry registry ) {
        registry.registerCustomEditor( Date.class, new CustomDateEditor( DateUtil.DATE_FORMAT, false ) );
        registry.registerCustomEditor( String.class, new StringTrimmerEditor( ",", false ) );
        
        // 覆盖默认转换器，否则无法处理八进制
        registry.registerCustomEditor( Short.class, new ShortEditor() );
        registry.registerCustomEditor( Color.class, new ColorEditor() );
        registry.registerCustomEditor( Sex.class, new EnumEditor( Sex.class ) );
        registry.registerCustomEditor( Font.class, new FontEditor() );
        registry.registerCustomEditor( Son.class, new PropertyEditorSupport() {
            @Override
            public void setAsText( String text ) throws IllegalArgumentException {
                setValue( new Son( text ) );
            }
        });
    }
}
