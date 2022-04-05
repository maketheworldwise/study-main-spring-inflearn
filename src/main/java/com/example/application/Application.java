package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // [MessageSource 리로딩]
    // 애플리케이션이 동작 중에 재배포하지 않고 특정 메시지만 교체하고 싶을 때 유용하게 사용 가능
    // 예를 들어, 웹 사이트 대문에 보이는 광고 메시지를 올렸는데, 실수로 오타가 있었고 그걸 고치려고 서버를 재배포하지 않고 그냥 메시지 소스에 해당하는 프로퍼티만 수정할 경우에 사용.
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3);
        return messageSource;
    }

}
