package com.example.application.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler { // implements ApplicationListener<MyEvent> {

//    @Override
//    public void onApplicationEvent(MyEvent event) {
//        System.out.println(event.getData());
//    }

    @EventListener
    // @Order(Ordered.HIGHEST_PRECEDENCE)
    @Async
    public void myEventHandler(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler : " + event.getData());
    }
}
