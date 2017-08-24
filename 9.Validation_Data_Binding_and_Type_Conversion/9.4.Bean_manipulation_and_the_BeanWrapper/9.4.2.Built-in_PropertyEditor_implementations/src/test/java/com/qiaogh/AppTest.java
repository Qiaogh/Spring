package com.qiaogh;

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

import com.qiaogh.domain.Person;
import com.qiaogh.util.DateUtil;


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
        
        BeanWrapper wrapper = new BeanWrapperImpl( new Person() );
        wrapper.registerCustomEditor( Date.class, new CustomDateEditor( DateUtil.DATE_FORMAT, false ) );
        wrapper.registerCustomEditor( String.class, new StringTrimmerEditor( ",", false ) );
        
        wrapper.setPropertyValue( "profile", profileStr );
        wrapper.setPropertyValue( "personClass", personClassStr );
        wrapper.setPropertyValue( "locked", locked );
        wrapper.setPropertyValue( "birthday", birthdayStr );
        wrapper.setPropertyValue( "age", ageStr );
        wrapper.setPropertyValue( "country", countryStr );
        wrapper.setPropertyValue( "contacts", contactsStr );
        wrapper.setPropertyValue( "money", moneyStr );
        wrapper.setPropertyValue( "blog", blogStr );
        
        Person person = (Person) wrapper.getWrappedInstance();
        Assert.assertNotNull( person.getProfile() );
        Assert.assertNotNull( person.getPersonClass() );
        Assert.assertNotNull( person.getBirthday() );
        Assert.assertNotNull( person.getAge() );
        Assert.assertNotNull( person.getCountry() );
        Assert.assertNotNull( person.getContacts() );
        Assert.assertNotNull( person.getMoney() );
        Assert.assertNotNull( person.getBlog() );
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
    }
}
