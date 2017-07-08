package com.qiaogh.collection;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qiaogh.domain.Man;

@Component
public class ManList extends ArrayList<Man> {

    private static final long serialVersionUID = 1L;

    @Autowired
    public ManList( Collection<Man> mans ) {
        super( mans );
    }
}
