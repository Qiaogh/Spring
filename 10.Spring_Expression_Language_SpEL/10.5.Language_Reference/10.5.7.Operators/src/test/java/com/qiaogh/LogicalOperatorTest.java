package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.qiaogh.domain.Person;


/**
 * Unit test for simple App.
 */
public class LogicalOperatorTest {

    @Test
    public void testAndOperator() {
        Person qiaogh = new Person( "Qiaogh" );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#this.name == 'Qiaogh' and #this.name.length() == 6" );
        boolean value = expression.getValue( qiaogh, Boolean.class );
        Assert.assertTrue( value );
    }

    @Test
    public void testOrOperator() {
        Person qiaogh = new Person( "Qiaogh" );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#this.name != 'Qiaogh' or #this.name.length() == 6" );
        boolean value = expression.getValue( qiaogh, Boolean.class );
        Assert.assertTrue( value );
    }
}
