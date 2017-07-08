package com.qiaogh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qiaogh.collection.ManList;
import com.qiaogh.collection.WomenList;

@Component
public class World {

    private ManList mans;
    private WomenList womens;
    
    public ManList getMans() {
        return mans;
    }
    @Autowired
    public void setMans( ManList mans ) {
        this.mans = mans;
    }
    public WomenList getWomens() {
        return womens;
    }
    @Autowired
    public void setWomens( WomenList womens ) {
        this.womens = womens;
    }
    @Override
    public String toString() {
        return "World [mans=" + mans + ", womens=" + womens + "]";
    }
}
