package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.qiaogh.domain.Person;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testSetGenericTypePropertyWithContext() {
        String name = "Qiaogh";
        String tellNumber = "15022730827";
        
        Person person = new Person();
        person.getTellNumbers().add( "" );
        
        EvaluationContext context = new StandardEvaluationContext( person );
        ExpressionParser expressionParser = new SpelExpressionParser();
        
        // expression of name
        Expression nameExpression = expressionParser.parseExpression( "name" );
        nameExpression.setValue( context, name );
        
        // expression of tells
        Expression tellsExpression = expressionParser.parseExpression( "tellNumbers[0]" );
        tellsExpression.setValue( context, tellNumber );
        
        Assert.assertNotNull( person.getName() );
        Assert.assertTrue( !person.getTellNumbers().isEmpty() );
        Assert.assertEquals( name, person.getName() );
        Assert.assertEquals( 1, person.getTellNumbers().size() );
        Assert.assertEquals( tellNumber, person.getTellNumbers().get( 0 ) );
    }

    @Test
    public void testSetGenericTypeProperty() {
        String name = "Qiaogh";
        String tellNumber = "15022730827";
        
        Person person = new Person();
        person.getTellNumbers().add( "" );
        
        ExpressionParser expressionParser = new SpelExpressionParser();
        
        // expression of name
        Expression nameExpression = expressionParser.parseExpression( "name" );
        nameExpression.setValue( person, name );
        
        // expression of tells
        Expression tellsExpression = expressionParser.parseExpression( "tellNumbers[0]" );
        tellsExpression.setValue( person, tellNumber );
        
        Assert.assertNotNull( person.getName() );
        Assert.assertTrue( !person.getTellNumbers().isEmpty() );
        Assert.assertEquals( name, person.getName() );
        Assert.assertEquals( 1, person.getTellNumbers().size() );
        Assert.assertEquals( tellNumber, person.getTellNumbers().get( 0 ) );
    }

    @Test
    public void testSetGenericTypePropertyException() {
        String name = "Qiaogh";
        
        Person person = new Person();
        person.getTellNumbers().add( "" );
        
        ExpressionParser expressionParser = new SpelExpressionParser();
        
        // expression of name
        Expression nameExpression = expressionParser.parseExpression( "name" );
        nameExpression.setValue( person, name );
        
        // expression of tells
        Expression tellsExpression = expressionParser.parseExpression( "tellNumbers[0]" );
        try {
            tellsExpression.setValue( person, new Object() );
            Assert.assertTrue( false );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof SpelEvaluationException );
        }
    }
}
