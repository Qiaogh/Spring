package com.qiaogh.domain;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import com.qiaogh.util.Sex;

public class Person {

    private byte[] profile;
    private Class<Person> personClass;
    private boolean locked;
    private Date birthday;
    private Integer age;
    private Locale country;
    private Properties contacts;
    private String money;
    private URL blog;
    private Short high;
    private Color color;
    private Sex sex;
    private Font font;
    private Son son;

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile( byte[] profile ) {
        this.profile = profile;
    }

    public Class<Person> getPersonClass() {
        return personClass;
    }

    public void setPersonClass( Class<Person> personClass ) {
        this.personClass = personClass;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked( boolean locked ) {
        this.locked = locked;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday( Date birthday ) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge( Integer age ) {
        this.age = age;
    }

    public Locale getCountry() {
        return country;
    }

    public void setCountry( Locale country ) {
        this.country = country;
    }

    public Properties getContacts() {
        return contacts;
    }

    public void setContacts( Properties contacts ) {
        this.contacts = contacts;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney( String money ) {
        this.money = money;
    }

    public URL getBlog() {
        return blog;
    }

    public void setBlog( URL blog ) {
        this.blog = blog;
    }

    public Short getHigh() {
        return high;
    }

    public void setHigh( Short high ) {
        this.high = high;
    }

    public Color getColor() {
        return color;
    }

    public void setColor( Color color ) {
        this.color = color;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex( Sex sex ) {
        this.sex = sex;
    }

    public Font getFont() {
        return font;
    }

    public void setFont( Font font ) {
        this.font = font;
    }

    public Son getSon() {
        return son;
    }

    public void setSon( Son son ) {
        this.son = son;
    }
}
