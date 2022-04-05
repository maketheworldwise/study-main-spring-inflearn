package com.example.application.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Value("${app.value}")
    String appValue;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // VM Options으로 설정된 -Dapp.name=spring에 접근하는 방법
        Environment environment = ctx.getEnvironment();
        System.out.println(environment.getProperty("app.name"));

        // app.properties에 접근하는 방법
        System.out.println(environment.getProperty("app.about"));

        // VM Options으로 설정된 -Dapp.priority=opt 접근하는 방법과
        // app.properties에 접근하는 방법중 VM Options이 우선 순위가 높음
        System.out.println(environment.getProperty("app.priority"));

        // 마찬가지로 VM Options으로 설정된 -Dapp.value=optvalue의 우선 순위가 높음
        System.out.println(appValue);
    }
}
