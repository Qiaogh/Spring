package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class MathematicalOperatorTest {

    @Test
    public void testAdditionOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertEquals( 2, expressionParser.parseExpression( "1 + 1" ).getValue( Integer.class ).intValue() );
        Assert.assertEquals( "11", expressionParser.parseExpression( "'1' + '1'" ).getValue( String.class ) );
    }

    @Test
    public void testSubtractionOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "2 - 1" );
        int value = expression.getValue( Integer.class );
        Assert.assertEquals( 1, value );
    }
    
    @Test
    public void testMultiplicationOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "2 * 1" );
        int value = expression.getValue( Integer.class );
        Assert.assertEquals( 2, value );
    }
    
    @Test
    public void testDivisionOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "2 / 1" );
        int value = expression.getValue( Integer.class );
        Assert.assertEquals( 2, value );
    }
    
    @Test
    public void testModuloOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "2 % 1" );
        int value = expression.getValue( Integer.class );
        Assert.assertEquals( 0, value );
    }
    
    @Test
    public void testPrecedence() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "1 + 2 * 3 / 4.00f % 5" );
        float value = expression.getValue( Float.class );
        Assert.assertEquals( 2.5, value, 0 );
    }
}
