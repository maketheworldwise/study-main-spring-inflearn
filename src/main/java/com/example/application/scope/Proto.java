package com.example.application.scope;

import org.springframework.stereotype.Component;

@Component // @Scope("prototype") : 매번 새로운 인스턴스를 생성함
public class Proto {

    // prototype 빈이 singleton 빈을 참조하는 것은 아무런 문제가 없음
//    @Autowired
//    Single single;
}
