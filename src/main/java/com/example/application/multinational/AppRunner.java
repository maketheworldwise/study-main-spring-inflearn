package com.example.application.multinational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    // ApplicationContext도 MessageSource 인터페이스를 구현했기 때문에 ApplicationContext로 대체 가능
    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(messageSource.getClass());

        while (true) {
            System.out.println(messageSource.getMessage("greeting", new String[]{"kevin"}, Locale.KOREA));
            System.out.println(messageSource.getMessage("greeting", new String[]{"kevin"}, Locale.getDefault()));
            Thread.sleep(1000l);
        }
    }
}