package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;


/**
 * Unit test for simple App.
 */
public class NumberTest {

    @Test
    public void testEqualOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertTrue( expressionParser.parseExpression( "1 == 1" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "1 == 2" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "1 == null" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "null == 2" ).getValue( Boolean.class ) );
    }
    
    @Test
    public void testNotEqualOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertFalse( expressionParser.parseExpression( "1 != 1" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "1 != 2" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "null != 1" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "1 != null" ).getValue( Boolean.class ) );
    }
    
    @Test
    public void testLessThanOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertTrue( expressionParser.parseExpression( "1 < 2" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "2 < 2" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "2 < 3" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "null < 1" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "1 < null" ).getValue( Boolean.class ) );
    }
    
    @Test
    public void testGreaterThanOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertFalse( expressionParser.parseExpression( "1 > 2" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "2 > 2" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "2 > 1" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "null > 1" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "1 > null" ).getValue( Boolean.class ) );
    }
}
