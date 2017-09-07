package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.qiaogh.domain.Person;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test() {
        String qiaoghName = "qiaoghName";
        Person qiaogh = new Person( qiaoghName );
        ParserContext parserContext = new TemplateParserContext( "#{", "}" );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "My name is #{#this.name}", parserContext );
        String value = expression.getValue( qiaogh, String.class );
        Assert.assertNotNull( value );
        Assert.assertEquals( qiaogh.introduce(), value );
    }
}
