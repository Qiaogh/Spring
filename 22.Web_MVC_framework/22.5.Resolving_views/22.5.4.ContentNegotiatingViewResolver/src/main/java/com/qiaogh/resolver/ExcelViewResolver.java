package com.qiaogh.resolver;

import com.qiaogh.view.ExcelView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class ExcelViewResolver implements ViewResolver {

    @Override
    public View resolveViewName( String viewName, Locale locale ) throws Exception {
        return new ExcelView();
    }
}
