package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.qiaogh.domain.Person;

public class TextualOperatorTest {

    @Test
    public void testInstanceOfOperator() {
        Person person = new Person();
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertTrue( expressionParser.parseExpression( "#this instanceof T(com.qiaogh.domain.Person)" ).getValue( person, Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "#root instanceof T(com.qiaogh.domain.Person)" ).getValue( person, Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "'' instanceof T(com.qiaogh.domain.Person)" ).getValue( person, Boolean.class ) );
    }
    
    @Test
    public void testMatchesOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertTrue( expressionParser.parseExpression( "'xyz' matches '.y.'" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "'xyz' matches 'y'" ).getValue( Boolean.class ) );
    }
    
    @Test
    public void testEqualOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertTrue( expressionParser.parseExpression( "1 eq 1" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "1 eq 2" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "1 eq null" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "null eq 2" ).getValue( Boolean.class ) );
    }
    
    @Test
    public void testNotEqualOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertFalse( expressionParser.parseExpression( "1 ne 1" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "1 ne 2" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "null ne 1" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "1 ne null" ).getValue( Boolean.class ) );
    }
    
    @Test
    public void testLessThanOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertTrue( expressionParser.parseExpression( "1 lt 2" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "2 lt 2" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "2 lt 3" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "null lt 1" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "1 lt null" ).getValue( Boolean.class ) );
    }
    
    @Test
    public void testLessEqualOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertTrue( expressionParser.parseExpression( "1 le 2" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "2 le 2" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "2 le 3" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "null le 1" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "1 le null" ).getValue( Boolean.class ) );
    }
    
    @Test
    public void testGreaterThanOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertFalse( expressionParser.parseExpression( "1 gt 2" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "2 gt 2" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "2 gt 1" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "null gt 1" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "1 gt null" ).getValue( Boolean.class ) );
    }
    
    @Test
    public void testGreaterEqualOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertFalse( expressionParser.parseExpression( "1 ge 2" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "2 ge 2" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "2 ge 1" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "null ge 1" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "1 ge null" ).getValue( Boolean.class ) );
    }
    
    @Test
    public void testDivisionOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "10 div 5" );
        int value = expression.getValue( Integer.class );
        Assert.assertEquals( 2, value );
    }
    
    @Test
    public void testModuloOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "11 % 2" );
        int value = expression.getValue( Integer.class );
        Assert.assertEquals( 1, value );
    }
    
    @Test
    public void testNotOperator() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertFalse( expressionParser.parseExpression( "not ( 1 == 1 )" ).getValue( Boolean.class ) );
        Assert.assertFalse( expressionParser.parseExpression( "not true" ).getValue( Boolean.class ) );
        Assert.assertTrue( expressionParser.parseExpression( "not false" ).getValue( Boolean.class ) );
    }
}
