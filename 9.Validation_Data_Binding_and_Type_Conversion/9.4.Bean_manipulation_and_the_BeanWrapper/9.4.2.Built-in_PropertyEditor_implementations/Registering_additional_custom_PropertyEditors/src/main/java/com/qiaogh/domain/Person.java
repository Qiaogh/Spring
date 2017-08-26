package com.qiaogh.domain;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.qiaogh.util.Sex;

@Component( "qiaogh" )
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

    @Value( "11111111" )
    public void setProfile( byte[] profile ) {
        this.profile = profile;
    }

    public Class<Person> getPersonClass() {
        return personClass;
    }

    @Value( "com.qiaogh.domain.Person" )
    public void setPersonClass( Class<Person> personClass ) {
        this.personClass = personClass;
    }

    public boolean isLocked() {
        return locked;
    }

    @Value( "false" )
    public void setLocked( boolean locked ) {
        this.locked = locked;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Value( "1988-10-07" )
    public void setBirthday( Date birthday ) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    @Value( "26" )
    public void setAge( Integer age ) {
        this.age = age;
    }

    public Locale getCountry() {
        return country;
    }

    @Value( "zh_CN" )
    public void setCountry( Locale country ) {
        this.country = country;
    }

    public Properties getContacts() {
        return contacts;
    }

    @Value( "name=police\ntel=110" )
    public void setContacts( Properties contacts ) {
        this.contacts = contacts;
    }

    public String getMoney() {
        return money;
    }

    @Value( "200,200.00" )
    public void setMoney( String money ) {
        this.money = money;
    }

    public URL getBlog() {
        return blog;
    }

    @Value( "http://www.baidu.com" )
    public void setBlog( URL blog ) {
        this.blog = blog;
    }

    public Short getHigh() {
        return high;
    }

    @Value( "0200" )
    public void setHigh( Short high ) {
        this.high = high;
    }

    public Color getColor() {
        return color;
    }

    @Value( "255,255,0" )
    public void setColor( Color color ) {
        this.color = color;
    }

    public Sex getSex() {
        return sex;
    }

    @Value( "MALE" )
    public void setSex( Sex sex ) {
        this.sex = sex;
    }

    public Font getFont() {
        return font;
    }

    @Value( "楷体" )
    public void setFont( Font font ) {
        this.font = font;
    }

    public Son getSon() {
        return son;
    }

    @Value( "Qiao--" )
    public void setSon( Son son ) {
        this.son = son;
    }
}
