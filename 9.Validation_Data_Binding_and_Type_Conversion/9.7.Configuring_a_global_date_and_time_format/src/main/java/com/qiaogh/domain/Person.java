package com.qiaogh.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Person {

    private String name;
    private Date birthday;
    private Float achievement;
    private BigDecimal money;
    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday( Date birthday ) {
        this.birthday = birthday;
    }
    public Float getAchievement() {
        return achievement;
    }
    public void setAchievement( Float achievement ) {
        this.achievement = achievement;
    }
    public BigDecimal getMoney() {
        return money;
    }
    public void setMoney( BigDecimal money ) {
        this.money = money;
    }
}
