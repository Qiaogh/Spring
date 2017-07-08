package com.qiaogh.collection;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qiaogh.domain.Women;

@Component
public class WomenList extends ArrayList<Women> {

    private static final long serialVersionUID = 1L;

    @Autowired
    public WomenList( Collection<Women> womens ) {
        super( womens );
    }
}
