package com.example.application.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames)); // 등록되어 있는 모든 빈 확인

        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println(bookService.bookRepository != null); // bookRepository 의존성 주입 확인
    }

}
