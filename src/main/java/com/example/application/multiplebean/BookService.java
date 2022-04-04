package com.example.application.multiplebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BookService {

    // [문제]
    // 주입할 수 있는 빈이 여러개 일 때, 스프링에서는 선택하지 못해 문제가 발생함
    //
    // [해결 방법]
    // - @Primary 어노테이션을 특정 Repository에 붙여 해결 (추천)
    // - @Qualifer("myBookRepository")를 필드에 붙여 Repository를 지정하여 해결
    // - List<BookRepositroy> bookRepositoryLists; 형태로 모든 빈을 주입 받아 해결

    @Autowired
    BookRepository bookRepository;

    public void printBookRepository() {
        System.out.println(bookRepository.getClass());
    }

    @PostConstruct
    public void afterBeanCreated() {
        System.out.println("해당 빈이 만들어진 후 (어노테이션 기반)");
        // 어노테이션 기반 외에도 BeanPostProcessor(postProcessBeforeInitialization, postProcessAfterInitialization)를 구현하는 방법도 존재
    }
}
