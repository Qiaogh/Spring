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
    public void testInvokeLiteralValueMethod() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "'Hello'.substring( 4 )" );
        String value = expression.getValue( String.class );
        Assert.assertNotNull( value );
        Assert.assertFalse( value.isEmpty() );
        Assert.assertEquals( 1, value.length() );
        Assert.assertEquals( "o", value );
    }
    
    @Test
    public void testInvokeRootMethod() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "substring( 4 )" );
        String value = expression.getValue( "Hello", String.class );
        Assert.assertNotNull( value );
        Assert.assertFalse( value.isEmpty() );
        Assert.assertEquals( 1, value.length() );
        Assert.assertEquals( "o", value );
    }
}
