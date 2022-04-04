package com.example.application.scanning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-scanning.xml");

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames)); // 등록되어 있는 모든 빈 확인

        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println(bookService.bookRepository != null); // bookRepository 의존성 주입 확인
    }

}
