package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.qiaogh.domain.Person;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testLiteralString() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "'Hello World'" );
        Assert.assertEquals( "Hello World", expression.getValue() );
    }
    
    @Test
    public void testLiteralStringMethodCall() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "'Hello World'.toString()" );
        Assert.assertEquals( "Hello World", expression.getValue( String.class ) );
    }
    
    @Test
    public void testLiteralStringPropertyCall() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "'Hello World'.bytes" );
        Assert.assertArrayEquals( "Hello World".getBytes(), (byte[]) expression.getValue() );
        
        // invoke getClass
        expression = expressionParser.parseExpression( "'Hello World'.class" );
        Assert.assertEquals( "".getClass(), expression.getValue() );
    }
    
    @Test
    public void testLiteralStringPropertySPropertyCall() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "'Hello World'.bytes.length" );
        Assert.assertEquals( "Hello World".getBytes().length, expression.getValue() );
    }
    
    @Test
    public void testLiteralStringConstractorCall() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "new String( 'Hello World' ).bytes.length" );
        Assert.assertEquals( new String( "Hello World" ).getBytes().length, expression.getValue() );
    }
    
    @Test
    public void testGetRootPropertyWithContext() {
        String name = "Qiaogh";
        Person person = new Person();
        person.setName( name );
        
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "name" );
        
        EvaluationContext context = new StandardEvaluationContext( person );
        Assert.assertEquals( name, expression.getValue( context ) );
    }
    
    @Test
    public void testGetRootProperty() {
        String name = "Qiaogh";
        Person person = new Person();
        person.setName( name );
        
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "name" );
        
        Assert.assertEquals( name, expression.getValue( person ) );
    }

    @Test
    public void testGetBooleanProperty() {
        String name = "Qiaogh";
        Person person = new Person();
        person.setName( name );
        
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( String.format( "name == '%s'", name ) );
        
        Assert.assertTrue( expression.getValue( person, Boolean.class ) );
    }
}
