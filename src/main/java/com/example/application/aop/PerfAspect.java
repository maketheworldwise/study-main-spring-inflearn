package com.example.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    // 해야할 일 (Advice), 어디에 적용할 것인가 (Pointcut)

//    @Around("execution(* com.example.application.aop.EventService.*(..))") // 모든 메서드
//    @Around("bean(simpleEventService)") // 빈에 적용
    @Around("@annotation(PerfLogging)") // 해당 어노테이션이 붙여진 메서드에만 적용
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }
}
