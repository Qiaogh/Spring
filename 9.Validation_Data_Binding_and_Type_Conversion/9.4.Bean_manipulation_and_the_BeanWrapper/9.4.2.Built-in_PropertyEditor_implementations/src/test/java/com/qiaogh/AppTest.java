package com.qiaogh;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.util.StringUtils;

import sun.beans.editors.ColorEditor;
import sun.beans.editors.EnumEditor;
import sun.beans.editors.FontEditor;
import sun.beans.editors.ShortEditor;

import com.qiaogh.domain.Person;
import com.qiaogh.util.DateUtil;
import com.qiaogh.util.Sex;


/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test() throws ParseException {
        String profileStr = "11111111";
        String personClassStr = Person.class.getName();
        String locked = "false";
        String birthdayStr = "1988-10-07";
        String ageStr = "26";
        String countryStr = Locale.CHINA.toString();
        String contactsStr = "name=police\ntel=110";
        String moneyStr = "200,200.00";
        String blogStr = "http://www.baidu.com";
        String highStr = "0200";
        String colorStr = "255,255,0";
        String sexStr = "MALE";
        String fontStr = "楷体";
        
        BeanWrapper wrapper = new BeanWrapperImpl( new Person() );
        wrapper.registerCustomEditor( Date.class, new CustomDateEditor( DateUtil.DATE_FORMAT, false ) );
        wrapper.registerCustomEditor( String.class, new StringTrimmerEditor( ",", false ) );
        
        // 覆盖默认转换器，否则无法处理八进制
        wrapper.registerCustomEditor( Short.class, new ShortEditor() );
        wrapper.registerCustomEditor( Color.class, new ColorEditor() );
        wrapper.registerCustomEditor( Sex.class, new EnumEditor( Sex.class ) );
        wrapper.registerCustomEditor( Font.class, new FontEditor() );
        
        wrapper.setPropertyValue( "profile", profileStr );
        wrapper.setPropertyValue( "personClass", personClassStr );
        wrapper.setPropertyValue( "locked", locked );
        wrapper.setPropertyValue( "birthday", birthdayStr );
        wrapper.setPropertyValue( "age", ageStr );
        wrapper.setPropertyValue( "country", countryStr );
        wrapper.setPropertyValue( "contacts", contactsStr );
        wrapper.setPropertyValue( "money", moneyStr );
        wrapper.setPropertyValue( "blog", blogStr );
        wrapper.setPropertyValue( "high", highStr );
        wrapper.setPropertyValue( "color", colorStr );
        wrapper.setPropertyValue( "sex", sexStr );
        wrapper.setPropertyValue( "font", fontStr );
        
        Person person = (Person) wrapper.getWrappedInstance();
        Assert.assertNotNull( person.getProfile() );
        Assert.assertNotNull( person.getPersonClass() );
        Assert.assertNotNull( person.getBirthday() );
        Assert.assertNotNull( person.getAge() );
        Assert.assertNotNull( person.getCountry() );
        Assert.assertNotNull( person.getContacts() );
        Assert.assertNotNull( person.getMoney() );
        Assert.assertNotNull( person.getBlog() );
        Assert.assertNotNull( person.getHigh() );
        Assert.assertNotNull( person.getColor() );
        Assert.assertNotNull( person.getSex() );
        Assert.assertNotNull( person.getFont() );
        Assert.assertEquals( profileStr.length(), person.getProfile().length );
        Assert.assertEquals( Person.class, person.getClass() );
        Assert.assertEquals( false, person.isLocked() );
        Assert.assertEquals( DateUtil.parseDate( birthdayStr ), person.getBirthday() );
        Assert.assertEquals( Integer.valueOf( ageStr ), person.getAge() );
        Assert.assertEquals( Locale.CHINA, person.getCountry() );
        Assert.assertEquals( 2, person.getContacts().keySet().size() );
        Assert.assertEquals( "police", person.getContacts().get( "name" ) );
        Assert.assertEquals( "110", person.getContacts().get( "tel" ) );
        Assert.assertEquals( StringUtils.deleteAny( moneyStr, "," ), person.getMoney() );
        Assert.assertEquals( blogStr, person.getBlog().toString() );
        Assert.assertEquals( Short.decode( highStr ), person.getHigh() );
        Assert.assertEquals( Color.YELLOW, person.getColor() );
        Assert.assertEquals( Sex.MALE, person.getSex() );
        Assert.assertEquals( Font.decode( fontStr ), person.getFont() );
    }
}
