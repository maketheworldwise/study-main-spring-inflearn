package com.example.application.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationEventPublisher publisher;

    // 앱이 구동될 때 이벤트를 발생시킴
    // 발생시킨 이벤트는 등록되어있는 이벤트 핸들러가 처리
    // 만약 여러 핸들러가 있다면, 어느 것이 먼저 실행되는지는 모르겠으나 순차적으로 실행이 됨 (순서가 중요하다면 @Order 어노테이션을 적용하면 됨)
    @Override
    public void run(ApplicationArguments args) throws Exception {
        publisher.publishEvent(new MyEvent(this, 100));
    }
}
