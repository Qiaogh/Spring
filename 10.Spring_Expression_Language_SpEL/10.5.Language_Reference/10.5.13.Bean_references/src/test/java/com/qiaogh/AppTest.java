package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.qiaogh.domain.Qiaogh;
import com.qiaogh.factory.QiaoghFactoryBean;
import com.qiaogh.resolver.SimpleBeanResolver;


/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testBeanReferences() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver( new SimpleBeanResolver() );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "@qiaogh" );
        Qiaogh qiaogh = expression.getValue( context, Qiaogh.class );
        Assert.assertNotNull( qiaogh );
        Assert.assertTrue( qiaogh instanceof Qiaogh );
        Assert.assertEquals( Qiaogh.getInstance(), qiaogh );
    }
    
    @Test
    public void testBeanFactoryReferences() throws Exception {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver( new SimpleBeanResolver() );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "&qiaogh" );
        QiaoghFactoryBean qiaoghFactorybean = expression.getValue( context, QiaoghFactoryBean.class );
        Assert.assertNotNull( qiaoghFactorybean );
        Assert.assertTrue( qiaoghFactorybean instanceof QiaoghFactoryBean );
        Assert.assertEquals( Qiaogh.getInstance(), qiaoghFactorybean.getObject() );
    }
}
