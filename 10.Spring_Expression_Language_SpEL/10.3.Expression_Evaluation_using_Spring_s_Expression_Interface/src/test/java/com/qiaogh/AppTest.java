package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

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
        Assert.assertEquals( "Hello World", expression.getValue() );
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
        Expression expression = expressionParser.parseExpression( "'Hello World'.bytes.length" );
        Assert.assertEquals( "Hello World".getBytes().length, expression.getValue() );
    }
}
