package com.qiaogh.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private List<String> tellNumbers = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public List<String> getTellNumbers() {
        return tellNumbers;
    }

    public void setTellNumbers( List<String> tellNumbers ) {
        this.tellNumbers = tellNumbers;
    }
}
