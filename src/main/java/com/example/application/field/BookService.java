package com.example.application.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired(required = false)
    BookRepository bookRepository;
}
