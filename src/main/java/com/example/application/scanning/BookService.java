package com.example.application.scanning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 2. Component Scanning
@Service
public class BookService {

    @Autowired
    public BookRepository bookRepository;

}
