package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.qiaogh.domain.Person;


/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testGetClass() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertEquals( Object.class, expressionParser.parseExpression( "T(Object)" ).getValue() );
        Assert.assertEquals( String.class, expressionParser.parseExpression( "T(String)" ).getValue() );
        Assert.assertEquals( Number.class, expressionParser.parseExpression( "T(Number)" ).getValue() );
        Assert.assertEquals( Integer.class, expressionParser.parseExpression( "T(Integer)" ).getValue() );
        Assert.assertEquals( Short.class, expressionParser.parseExpression( "T(Short)" ).getValue() );
        Assert.assertEquals( Byte.class, expressionParser.parseExpression( "T(Byte)" ).getValue() );
        Assert.assertEquals( Double.class, expressionParser.parseExpression( "T(Double)" ).getValue() );
        Assert.assertEquals( Float.class, expressionParser.parseExpression( "T(Float)" ).getValue() );
        Assert.assertEquals( Person.class, expressionParser.parseExpression( "T(com.qiaogh.domain.Person)" ).getValue() );
    }
    
    @Test
    public void testInvokeStaticMethod() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Assert.assertEquals( "100000", expressionParser.parseExpression( "T(String).valueOf( 100000 )" ).getValue() );
        Assert.assertEquals( "100000", expressionParser.parseExpression( "T(com.qiaogh.domain.Person).genId()" ).getValue() );
    }
}
