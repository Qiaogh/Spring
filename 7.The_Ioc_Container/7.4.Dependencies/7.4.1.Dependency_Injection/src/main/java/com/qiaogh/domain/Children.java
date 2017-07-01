package com.qiaogh.domain;

/**
 * Created by qiaogh on 2017/3/16.
 */
public class Children extends Person {

    private Person father;

    public Person getFather() {
        return father;
    }

    public void setFather( Person father ) {
        this.father = father;
    }
}
