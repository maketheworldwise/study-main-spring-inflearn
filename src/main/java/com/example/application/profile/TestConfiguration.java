package com.example.application.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test") // !test & prod 형태로도 프로파일 정의 가능
public class TestConfiguration {

    // test 프로파일일 경우에만 빈을 생성
    // IntelliJ의 Edit Configuration에서 Active Profiles 항목에 test를 작성하거나 VM Options 항목에 -Dspring.profiles.active=test 추가해주면 동작
    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }
}
