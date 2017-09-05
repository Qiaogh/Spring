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
        Expression expression = expressionParser.parseExpression( "'Qiaogh'" );
        String value = expression.getValue( String.class );
        Assert.assertEquals( "Qiaogh", value );
    }
    
    @Test
    public void testLiteralFloat() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "10.07" );
        float value = expression.getValue( Float.class );
        Assert.assertTrue( 10.07f == value );
    }
    
    @Test
    public void testLiteralInteger() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "10" );
        int value = expression.getValue( Integer.class );
        Assert.assertTrue( 10 == value );
    }
    
    @Test
    public void testLiteralHexInteger() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "0xA" );
        int value = expression.getValue( Integer.class );
        Assert.assertTrue( 10 == value );
    }
    
    @Test
    public void testLiteralBoolean() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "true" );
        boolean value = expression.getValue( Boolean.class );
        Assert.assertTrue( value );
    }
    
    @Test
    public void testLiteralNull() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "null" );
        Object value = expression.getValue();
        Assert.assertNull( value );
    }
}
