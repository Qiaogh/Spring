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
    public void testSetGenericTypePropertyWithContext() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "T(java.lang.Math).random() * 100.0" );
        int randomNum = expression.getValue( Integer.class );
        Assert.assertTrue( 100 > randomNum );
    }
}
