package com.example.application.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {

    // [문제점]
    // singleton 빈이 prototype 빈을 참조할 경우 prototype 빈이 업데이트되지 않음
    //
    // [해결 방법]
    // - singleton 빈이 prototype 빈을 직접 참조하지 않도록 프록시를 이용하여 해결 (@Scope에 proxyMode를 설정) (추천)
    // - ObjectProvider<Proto> proto로 필드를 수정

    @Autowired
    Proto proto;

    public Proto getProto() {
        return proto;
    }
}
