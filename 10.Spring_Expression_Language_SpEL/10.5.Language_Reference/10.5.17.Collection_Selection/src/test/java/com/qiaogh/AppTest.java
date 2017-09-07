package com.qiaogh;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testCollectionSelectionOfList() {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8 );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#root.?[#this >= 5]" );
        List<Integer> greaterEqualFiveNumber = expression.getValue( numbers, List.class );
        Assert.assertNotNull( greaterEqualFiveNumber );
        Assert.assertFalse( greaterEqualFiveNumber.isEmpty() );
        Assert.assertArrayEquals( new Object[] { 5, 6, 7, 8 }, greaterEqualFiveNumber.toArray() );
    }
    
    @Test
    public void testCollectionSelectionOfListSingletonValue() {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8 );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#root.?[#this eq 5]" );
        int value = expression.getValue( numbers, Integer.class );
        Assert.assertEquals( 5, value );
    }
    
    @Test
    public void testCollectionSelectionOfListFirstValue() {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8 );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#root.^[#this ge 5]" );
        int value = expression.getValue( numbers, Integer.class );
        Assert.assertEquals( 5, value );
    }
    
    @Test
    public void testCollectionSelectionOfListLastValue() {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8 );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#root.$[#this ge 5]" );
        int value = expression.getValue( numbers, Integer.class );
        Assert.assertEquals( 8, value );
    }

    @Test
    @SuppressWarnings( "unchecked" )
    public void testCollectionSelectionOfMap() {
        Map<String, Integer> numberMapping = buildNumberMapping();
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#root.?[#this.value ge 5]" );
        Map<String, Integer> greaterEqualFiveMapping = expression.getValue( numberMapping, Map.class );
        Assert.assertNotNull( greaterEqualFiveMapping );
        Assert.assertFalse( greaterEqualFiveMapping.isEmpty() );
        Assert.assertTrue( greaterEqualFiveMapping.containsKey( "5" ) );
        Assert.assertTrue( greaterEqualFiveMapping.containsKey( "6" ) );
        Assert.assertTrue( greaterEqualFiveMapping.containsKey( "7" ) );
        Assert.assertTrue( greaterEqualFiveMapping.containsKey( "8" ) );
    }
    
    @Test
    @SuppressWarnings( "unchecked" )
    public void testCollectionSelectionOfMapSingletonValue() {
        Map<String, Integer> numberMapping = buildNumberMapping();
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#root.?[#this.value eq 5]" );
        Map<String, Integer> fiveMapping = expression.getValue( numberMapping, Map.class );
        Assert.assertNotNull( fiveMapping );
        Assert.assertFalse( fiveMapping.isEmpty() );
        Assert.assertTrue( fiveMapping.containsKey( "5" ) );
    }
    
    private Map<String, Integer> buildNumberMapping() {
        Map<String, Integer> numberMapping = new HashMap<String, Integer>();
        numberMapping.put( "1", 1 );
        numberMapping.put( "2", 2 );
        numberMapping.put( "3", 3 );
        numberMapping.put( "4", 4 );
        numberMapping.put( "5", 5 );
        numberMapping.put( "6", 6 );
        numberMapping.put( "7", 7 );
        numberMapping.put( "8", 8 );
        return numberMapping;
    }
}
