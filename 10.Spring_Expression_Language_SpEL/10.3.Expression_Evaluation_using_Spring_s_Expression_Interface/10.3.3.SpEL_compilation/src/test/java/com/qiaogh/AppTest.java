package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.qiaogh.domain.Person;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testSetGenericTypePropertyWithContext() {
        String name = "Qiaogh";
        String tellNumber = "15022730827";
        
        Person person = new Person();
        
        EvaluationContext context = new StandardEvaluationContext( person );
        
        SpelParserConfiguration parserConfiguration = new SpelParserConfiguration( SpelCompilerMode.IMMEDIATE, AppTest.class.getClassLoader(), true, true, Short.MAX_VALUE );
        ExpressionParser expressionParser = new SpelExpressionParser( parserConfiguration );
        
        // expression of name
        Expression nameExpression = expressionParser.parseExpression( "name" );
        nameExpression.setValue( context, name );
        
        // expression of tells
        Expression tellsExpression = expressionParser.parseExpression( "tellNumbers[0]" );
        tellsExpression.setValue( context, tellNumber );
        
        Assert.assertNotNull( person.getName() );
        Assert.assertTrue( !person.getTellNumbers().isEmpty() );
        Assert.assertEquals( name, person.getName() );
        Assert.assertEquals( 1, person.getTellNumbers().size() );
        Assert.assertEquals( tellNumber, person.getTellNumbers().get( 0 ) );
    }
}
