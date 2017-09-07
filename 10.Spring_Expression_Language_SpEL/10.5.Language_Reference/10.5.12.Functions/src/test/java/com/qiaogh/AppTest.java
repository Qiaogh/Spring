package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.qiaogh.domain.Person;


/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testRegisterFunction() throws NoSuchMethodException, SecurityException {
        Person person = new Person( "Qiaogh" );
        StandardEvaluationContext context = new StandardEvaluationContext( person );
        context.registerFunction( "valueOf", String.class.getMethod( "valueOf", Object.class ) );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#valueOf( #root )" );
        String value = expression.getValue( context, String.class );
        Assert.assertNotNull( value );
        Assert.assertEquals( String.valueOf( person ), value );
    }
    
    @Test
    public void testOverrideRegisterFunction() throws NoSuchMethodException, SecurityException {
        int origin = 1;
        StandardEvaluationContext context = new StandardEvaluationContext( origin );
        context.registerFunction( "valueOf", String.class.getMethod( "valueOf", Object.class ) );
        context.registerFunction( "valueOf", String.class.getMethod( "valueOf", int.class ) );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#valueOf( #this )" );
        int value = expression.getValue( context, Integer.class );
        Assert.assertEquals( origin, value );
    }
}
