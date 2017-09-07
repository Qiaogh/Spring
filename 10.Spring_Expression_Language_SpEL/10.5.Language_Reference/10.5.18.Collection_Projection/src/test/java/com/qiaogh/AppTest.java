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

import com.qiaogh.domain.Person;



/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final String QIAOGH_NAME = "Qiaogh";
    private static final String QIY_NAME = "Qiy";
    
    @Test
    @SuppressWarnings( "unchecked" )
    public void testCollectionProjectionOfList() {
        String qiaoghName = QIAOGH_NAME;
        String qiyName = QIY_NAME;
        List<Person> persons = Arrays.asList( new Person( qiaoghName ), new Person( qiyName ) );
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression( "#root.![#this.name]" );
        List<String> names = expression.getValue( persons, List.class );
        Assert.assertNotNull( names );
        Assert.assertFalse( names.isEmpty() );
        Assert.assertEquals( qiaoghName, names.get( 0 ) );
        Assert.assertEquals( qiyName, names.get( 1 ) );
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testCollectionProjectionOfMap() {
       Map<String, Person> personMapping = buildPersonMapping();
       ExpressionParser expressionParser = new SpelExpressionParser();
       Expression expression = expressionParser.parseExpression( "#root.![#this.value.name]" );
       List<String> names = expression.getValue( personMapping, List.class );
       Assert.assertNotNull( names );
       Assert.assertFalse( names.isEmpty() );
       Assert.assertEquals( 2, names.size() );
    }
    
    private Map<String, Person> buildPersonMapping() {
        String qiaoghName = QIAOGH_NAME;
        String qiyName = QIY_NAME;
        Map<String, Person> personMapping = new HashMap<String, Person>();
        personMapping.put( qiaoghName, new Person( qiaoghName ) );
        personMapping.put( qiyName, new Person( qiyName ) );
        return personMapping;
    }
}
