package com.example.application.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    // 표현식
    @Value("#{1 + 1}")
    int value;

    @Value("#{'hello ' + 'world'}")
    String greeting;

    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    // Property (application.properties)
    @Value("${my.value}")
    int myValue;

    //표현식 안에 Property를 사용할 수 있지만 Property 안에 표현식은 있을 수 없음
    @Value("#{${my.value} eq 100}")
    boolean isMyValue100;

    // 빈을 참조
    @Value("#{sample.data}")
    int sampleData;

    public void run(ApplicationArguments args) throws Exception {
        System.out.println(value);
        System.out.println(greeting);
        System.out.println(trueOrFalse);
        System.out.println(myValue);
        System.out.println(isMyValue100);
        System.out.println(sampleData);

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("2 + 100");
        Integer exValue = expression.getValue(Integer.class);
        System.out.println(exValue);
    }
}
