package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
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
    public void testVariables() {
        Person qiaogh = new Person( "Qiaogh" );
        EvaluationContext context = new StandardEvaluationContext( qiaogh );
        context.setVariable( "name", "Qiaogh" );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#this.name eq #name" );
        boolean value = expression.getValue( context, Boolean.class );
        Assert.assertTrue( value );
    }
}
