package com.qiaogh;

import java.lang.reflect.Array;

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
    public void testBuildEmptyArray() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "new int[4]" );
        int[] intArray = (int[]) expression.getValue();
        Assert.assertNotNull( intArray );
        Assert.assertEquals( 4, Array.getLength( intArray ) );
        for ( int i = 0; i < intArray.length; i++ ) {
            Assert.assertEquals( 0, intArray[i] );
        }
    }
    
    @Test
    public void testBuildArray() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "new int[]{ 1, 2, 3.1 }" );
        int[] intArray = (int[]) expression.getValue();
        Assert.assertNotNull( intArray );
        Assert.assertEquals( 3, Array.getLength( intArray ) );
        Assert.assertEquals( 1, Array.getInt( intArray, 0 ) );
        Assert.assertEquals( 2, Array.getInt( intArray, 1 ) );
        Assert.assertEquals( 3, Array.getInt( intArray, 2 ) );
    }
    
    @Test
    public void testBuildMultipleArray() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "new int[4][5]" );
        int[][] multipleArray = (int[][]) expression.getValue();
        Assert.assertNotNull( multipleArray );
        Assert.assertEquals( 4, multipleArray.length );
        for ( int i = 0; i < multipleArray.length; i++ ) {
            Assert.assertNotNull( multipleArray[i] );
            Assert.assertEquals( 5, multipleArray[i].length );
            for ( int j = 0; j < multipleArray[i].length; j++ ) {
                Assert.assertEquals( 0, multipleArray[i][j] );
            }
        }
    }
}
