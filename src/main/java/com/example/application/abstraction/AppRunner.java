package com.example.application.abstraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(ctx.getClass()); // WebApplicationContext 중 하나가 출력

        Resource resource = ctx.getResource("classpath:application.properties");
        System.out.println(resource.getClass()); // classpath 접두어를 사용했으니 ClassPathResource가 출력
    }
}
