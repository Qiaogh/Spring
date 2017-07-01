package com.qiaogh.util;

import com.qiaogh.domain.Children;
import com.qiaogh.domain.Person;

/**
 * Created by qiaogh on 2017/3/16.
 */
public class ChildrenFactory {

    public static Person newInstance( Person father ) {
        Children children = new Children();
        children.setFather( father );
        return children;
    }
}
