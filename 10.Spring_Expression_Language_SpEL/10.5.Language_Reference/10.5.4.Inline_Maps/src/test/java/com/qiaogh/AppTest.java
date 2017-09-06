package com.qiaogh;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.ObjectUtils;


/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    @SuppressWarnings( "unchecked" )
    public void testInlineMap() {
        String nameKey = "name";
        String ageKey = "age";
        
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "{ 'name': 'Qiaogh', 'age': 26 }" );
        
        Map<String, Object> qiaogh = (Map<String, Object>) expression.getValue();
        Assert.assertNotNull( qiaogh );
        Assert.assertFalse( qiaogh.isEmpty() );
        Assert.assertEquals( 2, qiaogh.size() );
        Assert.assertTrue( qiaogh.containsKey( nameKey ) );
        Assert.assertFalse( ObjectUtils.isEmpty( qiaogh.get( nameKey ) ) );
        Assert.assertEquals( "Qiaogh", qiaogh.get( nameKey ) );
        Assert.assertTrue( qiaogh.containsKey( ageKey ) );
        Assert.assertFalse( ObjectUtils.isEmpty( qiaogh.get( ageKey ) ) );
        Assert.assertEquals( 26, qiaogh.get( ageKey ) );
    }
    
    @Test
    @SuppressWarnings( "unchecked" )
    public void testMultipleInlineMap() {
        String qiaoghKey = "qiaogh";
        String qiyKey = "qiy";
        String nameKey = "name";
        String ageKey = "age";
        
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "{ 'qiaogh': { 'name': 'Qiaogh', 'age': 26 }, 'qiy': { 'name': 'Qiy', age: 24 }}" );
        Map<String, Map<String, Object>> multipleMap = (Map<String, Map<String, Object>>) expression.getValue();
        Assert.assertNotNull( multipleMap );
        Assert.assertFalse( multipleMap.isEmpty() );
        Assert.assertEquals( 2, multipleMap.size() );
        
        Assert.assertTrue( multipleMap.containsKey( qiaoghKey ) );
        Map<String, Object> qiaogh = multipleMap.get( qiaoghKey );
        Assert.assertNotNull( qiaogh );
        Assert.assertFalse( qiaogh.isEmpty() );
        Assert.assertEquals( 2, qiaogh.size() );
        Assert.assertTrue( qiaogh.containsKey( nameKey ) );
        Assert.assertTrue( qiaogh.containsKey( ageKey ) );
        Assert.assertEquals( "Qiaogh", qiaogh.get( nameKey ) );
        Assert.assertEquals( 26, qiaogh.get( ageKey ) );
        
        Assert.assertTrue( multipleMap.containsKey( qiyKey ) );
        Map<String, Object> qiy = multipleMap.get( qiyKey );
        Assert.assertNotNull( qiy );
        Assert.assertFalse( qiy.isEmpty() );
        Assert.assertEquals( 2, qiy.size() );
        Assert.assertTrue( qiy.containsKey( nameKey ) );
        Assert.assertTrue( qiy.containsKey( ageKey ) );
        Assert.assertEquals( "Qiy", qiy.get( nameKey ) );
        Assert.assertEquals( 24, qiy.get( ageKey ) );
    }
    
    @Test
    public void testEmptyInlineMap() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "{:}" );
        Map<?, ?> emptyMap = (Map<?, ?>) expression.getValue();
        Assert.assertNotNull( emptyMap );
        Assert.assertTrue( emptyMap.isEmpty() );
    }
}
