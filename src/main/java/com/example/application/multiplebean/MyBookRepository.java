package com.example.application.multiplebean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary // 빈이 여러개가 있을 때 이 Repository를 사용하겠다는 의미
public class MyBookRepository implements BookRepository {
}
