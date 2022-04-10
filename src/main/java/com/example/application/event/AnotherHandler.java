package com.example.application.event;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

    @EventListener
    // @Order(Ordered.HIGHEST_PRECEDENCE + 2)
    @Async // 비동기로 처리를 하려면 이 어노테이션을 이용하면됨. 단, 순서는 보장하지 않기에 @Order 어노테이션 더 이상 의미가 없으니 삭제해줘야함
    public void anotherHandler(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("AnotherHandler : " + event.getData());
    }

    @EventListener
    @Async
    public void anotherHandler(ContextRefreshedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextRefreshedEvent");
    }

    @EventListener
    @Async
    public void anotherHandler(ContextClosedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextClosedEvent");
    }
}
