package com.qiaogh;

import java.util.List;

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
    @SuppressWarnings( "unchecked" )
    public void testInlineList() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "{ 1, 2, 3.1 , 4 }" );
        List<Number> numbers = (List<Number>) expression.getValue();
        Assert.assertNotNull( numbers );
        Assert.assertFalse( numbers.isEmpty() );
        Assert.assertEquals( 4, numbers.size() );
        Assert.assertEquals( 1, numbers.get( 0 ) );
        Assert.assertEquals( 2, numbers.get( 1 ) );
        Assert.assertEquals( 3.1, numbers.get( 2 ) );
        Assert.assertEquals( 4, numbers.get( 3 ) );
    }
    
    @Test
    @SuppressWarnings( "unchecked" )
    public void testMultipleInlineList() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "{{ 'a', 'b', 'c' }, { 1, 2, 3.1, 4 }}" );
        
        List<Object> multipleList = (List<Object>) expression.getValue();
        Assert.assertNotNull( multipleList );
        Assert.assertFalse( multipleList.isEmpty() );
        Assert.assertEquals( 2, multipleList.size() );
        
        List<String> strs = (List<String>) multipleList.get( 0 );
        Assert.assertNotNull( strs );
        Assert.assertFalse( strs.isEmpty() );
        Assert.assertEquals( 3, strs.size() );
        Assert.assertEquals( "a", strs.get( 0 ) );
        Assert.assertEquals( "b", strs.get( 1 ) );
        Assert.assertEquals( "c", strs.get( 2 ) );
        
        List<Number> numbers = (List<Number>) multipleList.get( 1 );
        Assert.assertNotNull( numbers );
        Assert.assertFalse( numbers.isEmpty() );
        Assert.assertEquals( 4, numbers.size() );
        Assert.assertEquals( 1, numbers.get( 0 ) );
        Assert.assertEquals( 2, numbers.get( 1 ) );
        Assert.assertEquals( 3.1, numbers.get( 2 ) );
        Assert.assertEquals( 4, numbers.get( 3 ) );
    }
    
    @Test
    public void testEmptyInlineList() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "{}" );
        List<?> emptyList = (List<?>) expression.getValue();
        Assert.assertNotNull( emptyList );
        Assert.assertTrue( emptyList.isEmpty() );
    }
}
