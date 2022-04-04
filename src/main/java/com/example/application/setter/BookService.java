package com.example.application.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    BookRepository bookRepository;

    // Setter 주입은 BookService 인스턴스 자체는 BookRepository 없이 만들 수는 있지만, @Autowired 어노테이션이 있기 때문에 실패함
    // 하지만 옵션을 주게 되면, BookService 인스턴스만 만들어서 빈으로 등록하고 BookRepository에 의존성이 주입되지 않은 상태에서 빈이 등록이 됨
    @Autowired(required = false)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
