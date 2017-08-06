package com.qiaogh;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import com.qiaogh.domain.Person;
import com.qiaogh.validator.PersonValidator;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testNoError() {
        Person person = new Person( "1", "Qiaogh", 26 );
        Validator validator = new PersonValidator();
        DataBinder dataBinder = new DataBinder( person );
        dataBinder.setValidator( validator );
        dataBinder.validate();
        Errors errors = dataBinder.getBindingResult();
        List<ObjectError> objectErrors = errors.getAllErrors();
        Assert.assertTrue( objectErrors.isEmpty() );
    }
    
    @Test
    public void testError() {
        Person person = new Person( "1", "Qiaogh", -10 );
        Validator validator = new PersonValidator();
        DataBinder dataBinder = new DataBinder( person );
        dataBinder.setValidator( validator );
        dataBinder.validate();
        Errors errors = dataBinder.getBindingResult();
        List<ObjectError> objectErrors = errors.getAllErrors();
        Assert.assertFalse( objectErrors.isEmpty() );
        Assert.assertEquals( "年龄不能小于 0！", objectErrors.get( 0 ).getDefaultMessage() );
    }
}
